package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bean.Matiere;

public interface DaoMatiere extends JpaRepository<Matiere, Integer> {

}
