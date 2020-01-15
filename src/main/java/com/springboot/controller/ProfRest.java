package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Professeur;
import com.springboot.service.iServiceProfesseur;

@RestController
@RequestMapping("/Rest/")
public class ProfRest {
	@Autowired
	private iServiceProfesseur serviceprof;
	
	@GetMapping("/Profs")
	public List<Professeur> getProfs() {
		
		return serviceprof.rechercheProf();
	}
	
	@GetMapping("/Profs/{id}")
	public Professeur getProf(@PathVariable("id") int id) {
		
		return serviceprof.rechercheProfId(id);
	}

}
