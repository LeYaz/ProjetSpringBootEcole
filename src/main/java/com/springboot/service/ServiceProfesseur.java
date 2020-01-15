package com.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bean.Professeur;
import com.springboot.dao.DaoProfesseur;

@Service
public class ServiceProfesseur implements iServiceProfesseur {
	@Autowired
	DaoProfesseur daoprof;
	
	@Transactional
	@Override
	public List<Professeur> rechercheProf() {
		// TODO Auto-generated method stub
		return daoprof.findAll();
	}

	@Transactional
	@Override
	public void creerProf(Professeur prof) {
		// TODO Auto-generated method stub
		daoprof.save(prof);
	}

	@Transactional
	@Override
	public void modifierProf(Professeur prof) {
		// TODO Auto-generated method stub
		daoprof.save(prof);
	}

	@Transactional
	@Override
	public void supprimerProf(Professeur prof) {
		// TODO Auto-generated method stub
		daoprof.deleteById(prof.getId());
	}

	@Transactional
	@Override
	public Professeur rechercheProfId(int id) {
		// TODO Auto-generated method stub
		return daoprof.findById(id).get();
	}

}
