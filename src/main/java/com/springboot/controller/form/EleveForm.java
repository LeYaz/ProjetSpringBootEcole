package com.springboot.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EleveForm {
/**
 * Qu'est ce que je mets dans mon formulaire
 * en saisie et en affichage
 */
	private Integer id;
	
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@NotEmpty
	private String classe;
	@NotEmpty
	private String datenaissance;
	@NotEmpty
	@Pattern(regexp = "HOMME|FEMME")
	private String sexe;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
	
	
}
