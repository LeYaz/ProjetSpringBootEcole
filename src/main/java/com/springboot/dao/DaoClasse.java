package com.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bean.Classe;

public interface DaoClasse 
extends JpaRepository<Classe, Integer> {
 @Query("select e.classe from Eleve e where e.nom like ?1")
 public List<Classe> findByEleve(String nom);
}
