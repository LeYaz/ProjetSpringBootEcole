package com.springboot.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ProfesseurForm {
/**
 * Qu'est ce que je mets dans mon formulaire
 * en saisie et en affichage
 */
	private Integer id;
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	/**
	 * Rajout du Pattern pour vérifier si c'est une date
	 */
	@NotEmpty
	private String datenaissance;
	@NotEmpty
	private String adresse;
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
	public String getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
	
}
