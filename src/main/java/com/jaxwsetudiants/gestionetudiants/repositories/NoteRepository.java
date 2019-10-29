package com.jaxwsetudiants.gestionetudiants.repositories;

import com.jaxwsetudiants.gestionetudiants.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}
