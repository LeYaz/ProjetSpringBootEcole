package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bean.Eleve;

public interface DaoEleve 
extends JpaRepository<Eleve, Integer> {

}
