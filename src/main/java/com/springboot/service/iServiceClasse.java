package com.springboot.service;

import java.util.List;

import com.springboot.bean.Classe;

public interface iServiceClasse {
	public List<Classe> rechercheClasse();
	public Classe rechercheClasseId(final int id);
	public void creerClasse(final Classe pclasse);
	public void modifierClasse(final Classe pclasse);
	public void supprimerClasse(final Classe pclasse);
}
