package com.springboot.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NoteForm {

	private Integer id;
	
	@NotEmpty 
	private String date_saisie;
	
	@NotEmpty
	private String eleve;
	
	@NotEmpty
	private String classe;
	
	@NotEmpty
	private String matiere;
	
	@NotEmpty 
	private String professeur;
	

	private String idtrimestre;
	
	@NotEmpty
	private String note;
	
	@NotEmpty
	private String avis;
	
	@NotEmpty
	private String avancement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate_saisie() {
		return date_saisie;
	}

	public void setDate_saisie(String date_saisie) {
		this.date_saisie = date_saisie;
	}

	public String getEleve() {
		return eleve;
	}

	public void setEleve(String eleve) {
		this.eleve = eleve;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getProfesseur() {
		return professeur;
	}

	public void setProfesseur(String professeur) {
		this.professeur = professeur;
	}

	public String getIdtrimestre() {
		return idtrimestre;
	}

	public void setIdtrimestre(String idtrimestre) {
		this.idtrimestre = idtrimestre;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public String getAvancement() {
		return avancement;
	}

	public void setAvancement(String avancement) {
		this.avancement = avancement;
	}
	
	
}
