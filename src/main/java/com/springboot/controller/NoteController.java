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
import com.springboot.bean.Matiere;
import com.springboot.bean.Note;
import com.springboot.bean.Professeur;
import com.springboot.controller.form.ClasseForm;
import com.springboot.controller.form.EleveForm;
import com.springboot.controller.form.NoteForm;
import com.springboot.service.iServiceClasse;
import com.springboot.service.iServiceEleve;
import com.springboot.service.iServiceMatiere;
import com.springboot.service.iServiceNote;
import com.springboot.service.iServiceProfesseur;

@Controller
public class NoteController {

	@Autowired
	private iServiceNote servicenote;
	
	@Autowired
	private iServiceClasse serviceclasse;
	
	@Autowired
	private iServiceEleve serviceeleve;
	
	@Autowired
	private iServiceMatiere servicematiere;
	
	@Autowired
	private iServiceProfesseur serviceprofesseur;
	
	@GetMapping("/afficherNote")
	public String afficher(Model pmodel) {
		List<Note> lnote = servicenote.rechercheNote();
		List<Classe> lclasse = serviceclasse.rechercheClasse();
		List<Eleve> leleve = serviceeleve.rechercheEleve();
		List<Matiere> lmatiere = servicematiere.rechercheMatiere();
		List<Professeur> lprofesseur = serviceprofesseur.rechercheProf();
		pmodel.addAttribute("listenote", lnote);
		pmodel.addAttribute("listeclasse", lclasse);
		pmodel.addAttribute("listeeleve",leleve);
		pmodel.addAttribute("listematiere",lmatiere);
		pmodel.addAttribute("listeprofesseur",lprofesseur);
		pmodel.addAttribute("action", "CreerNote");
		if(pmodel.containsAttribute("noteform") == false) {
			NoteForm noteform = new NoteForm();
			noteform.setId(0);
			pmodel.addAttribute("noteform",noteform);
		}
		
		return "notes";
	}
	
	private Note convertForm(NoteForm noteform) throws Exception {
		Note pnote = new Note();
		Professeur prof = serviceprofesseur.rechercheProfId(Integer.valueOf(noteform.getProfesseur()));
		Classe classe = serviceclasse.rechercheClasseId(Integer.valueOf(noteform.getClasse()));
		Eleve eleve =serviceeleve.rechercheEleveId(Integer.valueOf(noteform.getEleve()));
		Matiere matiere = servicematiere.rechercheMatiereId(Integer.valueOf(noteform.getMatiere()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date madate = sdf.parse(noteform.getDate_saisie());
		pnote.setId(noteform.getId());
		
		pnote.setClasse(classe);
		pnote.setProfesseur(prof);
		pnote.setEleve(eleve);
		pnote.setMatiere(matiere);
		pnote.setAvis(noteform.getAvis());
		pnote.setAvancement(Float.valueOf(noteform.getAvancement()));
		pnote.setDate_saisie(madate);
		pnote.setIdtrimestre(1);
		pnote.setNote(Integer.valueOf(noteform.getNote()));
		
		return pnote;
	}
	
	@GetMapping("/afficherModifierNote/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Note pnote = servicenote.rechercheNoteId(id);
		List<Classe> lclasse = serviceclasse.rechercheClasse();
		List<Eleve> leleve = serviceeleve.rechercheEleve();
		List<Matiere> lmatiere = servicematiere.rechercheMatiere();
		List<Professeur> lprofesseur = serviceprofesseur.rechercheProf();
		
		pmodel.addAttribute("listeclasse", lclasse);
		pmodel.addAttribute("listeeleve",leleve);
		pmodel.addAttribute("listematiere",lmatiere);
		pmodel.addAttribute("listeprofesseur",lprofesseur);
		pmodel.addAttribute("action", "ModifierNote");
		if(pmodel.containsAttribute("noteform") == false) {
			NoteForm noteform = new NoteForm();
			noteform.setId(pnote.getId());
			
			noteform.setClasse(String.valueOf(pnote.getClasse().getId()));
			noteform.setProfesseur(String.valueOf(pnote.getProfesseur().getId()));
			noteform.setEleve(String.valueOf(pnote.getEleve().getId()));
			noteform.setMatiere(String.valueOf(pnote.getMatiere().getId()));
			noteform.setAvis(pnote.getAvis());
			noteform.setAvancement(String.valueOf(pnote.getAvancement()));
			noteform.setIdtrimestre(String.valueOf(pnote.getIdtrimestre()));
			noteform.setDate_saisie(new SimpleDateFormat("yyyy-MM-dd").format(pnote.getDate_saisie()));
			noteform.setNote(String.valueOf(pnote.getNote()));
			pmodel.addAttribute("noteform", noteform);
		}
		return "notes";
	}
	
	@GetMapping("/SupprimerNote/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		Note pnote = servicenote.rechercheNoteId(id);
		if(pnote  != null) {
			servicenote.supprimerNote(pnote);;
		}
		return this.afficher(pmodel);
	}
	
	@PostMapping("/CreerNote")
	public String ajoutNote( 
			@Valid @ModelAttribute(name = "noteform") 
			NoteForm noteform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Note pnote = convertForm(noteform);
				servicenote.creerNote(pnote);
			}
			catch(Exception e) {
				
				System.err.println(e.getMessage());
			}
		}
		else
		{
			System.err.println(presult);
		}
		return this.afficher(pmodel);
	}

	@PostMapping("/ModifierNote")
	public String modifieNote( 
			@Valid @ModelAttribute(name = "noteform") 
			NoteForm noteform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Note pnote = convertForm(noteform);
				servicenote.modifierNote(pnote);
				
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.afficher(pmodel);
	}
}
