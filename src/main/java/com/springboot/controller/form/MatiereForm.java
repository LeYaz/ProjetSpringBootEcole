package com.springboot.controller.form;

import javax.validation.constraints.NotEmpty;

public class MatiereForm {
	private Integer id;
	
	@NotEmpty
	private String nom;

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
	
	
}
