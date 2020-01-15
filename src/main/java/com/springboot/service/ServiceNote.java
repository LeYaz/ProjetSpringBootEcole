package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Note;
import com.springboot.dao.DaoNote;

@Service
public class ServiceNote implements iServiceNote {
	@Autowired
	DaoNote dao;
	
	@Transactional
	@Override
	public List<Note> rechercheNote() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Transactional
	@Override
	public Note rechercheNoteId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerNote(Note pnote) {
		// TODO Auto-generated method stub
		dao.save(pnote);
	}

	@Transactional
	@Override
	public void modifierNote(Note pnote) {
		// TODO Auto-generated method stub
		dao.save(pnote);
	}

	@Transactional
	@Override
	public void supprimerNote(Note pnote) {
		// TODO Auto-generated method stub
		dao.deleteById(pnote.getId());
	}

}
