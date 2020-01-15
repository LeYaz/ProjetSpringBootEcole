package com.springboot.service;

import java.util.List;

import com.springboot.bean.Matiere;

public interface iServiceMatiere {
	public List<Matiere> rechercheMatiere();
	public Matiere rechercheMatiereId(final int id);
	public void creerMatiere(final Matiere pmatiere);
	public void modifierMatiere(final Matiere pmatiere);
	public void supprimerMatiere(final Matiere pmatiere);
}
