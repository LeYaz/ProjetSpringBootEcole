package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bean.Professeur;

public interface DaoProfesseur 
extends JpaRepository<Professeur, Integer> {

}
