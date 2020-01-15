package com.springboot.service;

import java.util.List;

import com.springboot.bean.Note;

public interface iServiceNote {
	public List<Note> rechercheNote();
	public Note rechercheNoteId(final int id);
	public void creerNote(final Note pnote);
	public void modifierNote(final Note pnote);
	public void supprimerNote(final Note pnote);
}
