package com.springboot.service;

import java.util.List;

import com.springboot.bean.Professeur;

public interface iServiceProfesseur {
	public List<Professeur> rechercheProf();
	public Professeur rechercheProfId(final int id);
	public void creerProf(final Professeur prof);
	public void modifierProf(final Professeur prof);
	public void supprimerProf(final Professeur prof);
}
