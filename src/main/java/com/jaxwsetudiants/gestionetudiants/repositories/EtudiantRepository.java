package com.jaxwsetudiants.gestionetudiants.repositories;

import com.jaxwsetudiants.gestionetudiants.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EtudiantRepository extends JpaRepository<Etudiant,String> {

    @Override
    Optional<Etudiant> findById(String s);

    @Override
    boolean existsById(String s);
}
