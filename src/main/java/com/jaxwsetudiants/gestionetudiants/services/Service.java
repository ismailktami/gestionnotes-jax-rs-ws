package com.jaxwsetudiants.gestionetudiants.services;

import com.jaxwsetudiants.gestionetudiants.entities.Etudiant;
import com.jaxwsetudiants.gestionetudiants.entities.Note;

import java.util.List;

public interface Service {
public Etudiant addEtudiant(Etudiant e );
public List<Etudiant> getAll();
public Etudiant getMajorant();
public Etudiant addNote(String cne,float note);
    public List<Note> getAllNoteByEtudiant(String cne);
    public Etudiant removeEtudiant(String cne);


}
