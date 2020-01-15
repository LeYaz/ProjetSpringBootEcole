package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bean.Note;

public interface DaoNote extends JpaRepository<Note, Integer>  {

}
