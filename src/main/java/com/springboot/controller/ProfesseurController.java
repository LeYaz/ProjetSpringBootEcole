package com.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bean.Professeur;
import com.springboot.controller.form.ProfesseurForm;
import com.springboot.enums.Genre;
import com.springboot.service.iServiceProfesseur;

@Controller
public class ProfesseurController {
	@Autowired
	private iServiceProfesseur serviceprof;
	
	private Professeur convertForm(ProfesseurForm profform) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date madate = sdf.parse(profform.getDatenaissance());
		Professeur prof = new Professeur();
		prof.setId(profform.getId());
		prof.setAdresse(profform.getAdresse());
		prof.setDatenaissance(madate);
		prof.setNom(profform.getNom());
		prof.setPrenom(profform.getPrenom());
		prof.setSexe(Genre.valueOf(profform.getSexe()));
		return prof;
	}
	
	@GetMapping("/afficherCreerProf")
	public String getAffiche(Model pmodel) {
		List<Professeur> lprof = serviceprof.rechercheProf();
		pmodel.addAttribute("listeprof", lprof);
		pmodel.addAttribute("action", "CreerProf");
		if(pmodel.containsAttribute("profform") == false) {
			ProfesseurForm profform = new ProfesseurForm();
			profform.setId(0);
			pmodel.addAttribute("profform", profform);
		}
		return "professeurs";
	}
	
	@GetMapping("/afficherModifierProf/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Professeur prof = serviceprof.rechercheProfId(id);
		pmodel.addAttribute("listeprof", null);
		pmodel.addAttribute("action", "ModifierProf");
		if(pmodel.containsAttribute("profform") == false) {
			ProfesseurForm profform = new ProfesseurForm();
			profform.setId(prof.getId());
			profform.setAdresse(prof.getAdresse());
			profform.setNom(prof.getNom());
			profform.setPrenom(prof.getPrenom());
			profform.setDatenaissance(new 
					SimpleDateFormat("yyyy-MM-dd").format(
					prof.getDatenaissance()));
			profform.setSexe(prof.getSexe().name());
			pmodel.addAttribute("profform", profform);
		}
		return "professeurs";
	}
	
	@GetMapping("/SupprimerProf/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		Professeur prof = serviceprof.rechercheProfId(id);
		if(prof != null) {
			serviceprof.supprimerProf(prof);
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/CreerProf")
	public String ajoutProf( 
			@Valid @ModelAttribute ProfesseurForm profform,
			BindingResult presult,Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Professeur prof = convertForm(profform);
				serviceprof.creerProf(prof);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/ModifierProf")
	public String modifieProf( 
			@Valid @ModelAttribute ProfesseurForm profform,
			BindingResult presult,Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Professeur prof = convertForm(profform);
				serviceprof.modifierProf(prof);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
}
