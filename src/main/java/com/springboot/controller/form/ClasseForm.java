package com.springboot.controller.form;

import javax.validation.constraints.NotEmpty;

public class ClasseForm {
/**
 * Qu'est ce que je mets dans mon formulaire
 * en saisie et en affichage
 */
	private Integer id;
	
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prof;
	
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
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	
	
	
}
