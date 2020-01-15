package com.springboot.service;

import java.util.List;

import com.springboot.bean.Eleve;

public interface iServiceEleve {
	public List<Eleve> rechercheEleve();
	public Eleve rechercheEleveId(final int id);
	public void creerEleve(final Eleve peleve);
	public void modifierEleve(final Eleve peleve);
	public void supprimerEleve(final Eleve peleve);
}
