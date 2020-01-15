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

import com.springboot.bean.Classe;
import com.springboot.bean.Eleve;
import com.springboot.bean.Professeur;
import com.springboot.controller.form.ClasseForm;
import com.springboot.controller.form.EleveForm;
import com.springboot.enums.Genre;
import com.springboot.controller.form.EleveForm;
import com.springboot.service.iServiceClasse;
import com.springboot.service.iServiceEleve;

@Controller
public class EleveController {
	@Autowired
	private iServiceClasse serviceclasse;
	@Autowired
	private iServiceEleve serviceeleve;
	
	private Eleve convertForm(EleveForm eleveform) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date madate = sdf.parse(eleveform.getDatenaissance());
		Eleve peleve = new Eleve();
		Classe pclasse = serviceclasse.rechercheClasseId(
				Integer.valueOf(eleveform.getClasse()));
		peleve.setId(eleveform.getId());
		peleve.setNom(eleveform.getNom());
		peleve.setPrenom(eleveform.getPrenom());
		peleve.setClasse(pclasse);
		peleve.setDatenaissance(madate);
		peleve.setSexe(Genre.valueOf(eleveform.getSexe()));
		return peleve;
	}
	
	@GetMapping("/afficherCreerEleve")
	public String getAffiche(Model pmodel) {
		List<Classe> lclasse = serviceclasse.rechercheClasse();
		List<Eleve> leleve = serviceeleve.rechercheEleve();
		pmodel.addAttribute("listeclasse", lclasse);
		pmodel.addAttribute("listeeleve", leleve);
		pmodel.addAttribute("action", "CreerEleve");
		if(pmodel.containsAttribute("eleveform") == false) {
			EleveForm eleveform = new EleveForm();
			eleveform.setId(0);
			pmodel.addAttribute("eleveform",eleveform);
		}
		return "eleves";
	}
	
	@GetMapping("/afficherModifierEleve/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Eleve peleve = serviceeleve.rechercheEleveId(id);
		List<Classe> lclasse = serviceclasse.rechercheClasse();
		pmodel.addAttribute("listeclasse", lclasse);
		pmodel.addAttribute("listeeleve", null);
		pmodel.addAttribute("action", "ModifierEleve");
		if(pmodel.containsAttribute("eleveform") == false) {
			EleveForm eleveform = new EleveForm();
			eleveform.setId(peleve.getId());
			eleveform.setClasse(String.valueOf(
					peleve.getClasse().getId()));
			eleveform.setNom(peleve.getNom());
			eleveform.setPrenom(peleve.getPrenom());
			eleveform.setDatenaissance(new 
					SimpleDateFormat("yyyy-MM-dd").format(
							peleve.getDatenaissance()));
			pmodel.addAttribute("eleveform", eleveform);
		}
		return "eleves";
	}
	
	@GetMapping("/SupprimerEleve/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		Eleve peleve = serviceeleve.rechercheEleveId(id);
		if(peleve  != null) {
			serviceeleve.supprimerEleve(peleve);;
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/CreerEleve")
	public String ajoutClasse( 
			@Valid @ModelAttribute(name = "eleveform") 
			EleveForm eleveform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Eleve peleve = convertForm(eleveform);
				serviceeleve.creerEleve(peleve);
			}
			catch(Exception e) {
				
				System.err.println(e.getMessage());
			}
		}
		else
		{
			System.err.println(presult);
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/ModifierEleve")
	public String modifieClasse( 
			@Valid @ModelAttribute(name = "eleveform") 
			EleveForm eleveform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Eleve peleve = convertForm(eleveform);
				serviceeleve.modifierEleve(peleve);
				
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
}
