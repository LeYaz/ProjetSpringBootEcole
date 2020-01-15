package com.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bean.Eleve;
import com.springboot.dao.DaoEleve;

@Service
public class ServiceEleve implements iServiceEleve {
	@Autowired
	DaoEleve daoeleve;
	
	@Transactional
	@Override
	public List<Eleve> rechercheEleve() {
		// TODO Auto-generated method stub
		return daoeleve.findAll();
	}

	@Transactional
	@Override
	public void creerEleve(Eleve peleve) {
		// TODO Auto-generated method stub
		daoeleve.save(peleve);
	}

	@Transactional
	@Override
	public void modifierEleve(Eleve peleve) {
		// TODO Auto-generated method stub
		daoeleve.save(peleve);
	}

	@Transactional
	@Override
	public void supprimerEleve(Eleve peleve) {
		// TODO Auto-generated method stub
		daoeleve.deleteById(peleve.getId());
	}

	@Transactional
	@Override
	public Eleve rechercheEleveId(int id) {
		// TODO Auto-generated method stub
		return daoeleve.findById(id).get();
	}

}
