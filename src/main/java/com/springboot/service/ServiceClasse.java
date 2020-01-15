package com.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bean.Classe;
import com.springboot.dao.DaoClasse;

@Service
public class ServiceClasse implements iServiceClasse {
	@Autowired
	DaoClasse daoclasse;
	
	@Transactional
	@Override
	public List<Classe> rechercheClasse() {
		// TODO Auto-generated method stub
		return daoclasse.findAll();
	}

	@Transactional
	@Override
	public Classe rechercheClasseId(int id) {
		// TODO Auto-generated method stub
		return daoclasse.findById(id).get();
	}

	@Transactional
	@Override
	public void creerClasse(Classe pclasse) {
		// TODO Auto-generated method stub
		daoclasse.save(pclasse);
	}

	@Transactional
	@Override
	public void modifierClasse(Classe pclasse) {
		// TODO Auto-generated method stub
		daoclasse.save(pclasse);
	}

	@Transactional
	@Override
	public void supprimerClasse(Classe pclasse) {
		// TODO Auto-generated method stub
		daoclasse.deleteById(pclasse.getId());
	}

}
