package com.springboot.controller;

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
import com.springboot.bean.Professeur;
import com.springboot.controller.form.ClasseForm;
import com.springboot.service.iServiceClasse;
import com.springboot.service.iServiceProfesseur;

@Controller
public class ClasseController {
	@Autowired
	private iServiceClasse serviceclasse;
	@Autowired
	private iServiceProfesseur serviceprof;
	
	private Classe convertForm(ClasseForm classeform) throws Exception {
		Classe pclasse = new Classe();
		Professeur prof = serviceprof.rechercheProfId(
				Integer.valueOf(classeform.getProf()));
		pclasse.setId(classeform.getId());
		pclasse.setNom(classeform.getNom());
		pclasse.setProf(prof);
		return pclasse;
	}
	
	@GetMapping("/afficherCreerClasse")
	public String getAffiche(Model pmodel) {
		List<Classe> lclasse = serviceclasse.rechercheClasse();
		List<Professeur> lprof = serviceprof.rechercheProf();
		pmodel.addAttribute("listeclasse", lclasse);
		pmodel.addAttribute("listeprof", lprof);
		pmodel.addAttribute("action", "CreerClasse");

		if(pmodel.containsAttribute("classeform") == false) {
			ClasseForm classeform = new ClasseForm();
			classeform.setId(0);
			pmodel.addAttribute("classeform",classeform);
		}
		return "classes";
	}
	
	@GetMapping("/afficherModifierClasse/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Classe pclasse = serviceclasse.rechercheClasseId(id);
		List<Professeur> lprof = serviceprof.rechercheProf();
		pmodel.addAttribute("listeclasse", null);
		pmodel.addAttribute("listeprof", lprof);
		pmodel.addAttribute("action", "ModifierClasse");
		if(pmodel.containsAttribute("classeform") == false) {
			ClasseForm classeform = new ClasseForm();
			classeform.setId(pclasse.getId());
			classeform.setProf(String.valueOf(pclasse.getProf().getId()));
			classeform.setNom(pclasse.getNom());
			
			pmodel.addAttribute("classeform", classeform);
		}
		return "classes";
	}
	
	@GetMapping("/SupprimerClasse/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		Classe pclasse = serviceclasse.rechercheClasseId(id);
		if(pclasse != null) {
			serviceclasse.supprimerClasse(pclasse);;
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/CreerClasse")
	public String ajoutClasse( 
			@Valid @ModelAttribute(name = "classeform") ClasseForm classeform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Classe pclasse = convertForm(classeform);
				serviceclasse.creerClasse(pclasse);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/ModifierClasse")
	public String modifieClasse( 
			@Valid @ModelAttribute(name = "classeform") ClasseForm classeform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Classe pclasse = convertForm(classeform);
				serviceclasse.creerClasse(pclasse);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
}
