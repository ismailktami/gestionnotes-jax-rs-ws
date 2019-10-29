package com.jaxwsetudiants.gestionetudiants.services;

import com.jaxwsetudiants.gestionetudiants.entities.Etudiant;
import com.jaxwsetudiants.gestionetudiants.entities.Note;
import com.jaxwsetudiants.gestionetudiants.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebService
public class EtudiantServiceSoap implements Service {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @WebMethod
    @Override
    public Etudiant addEtudiant(Etudiant e ){
        System.out.println(e.getCne());
        return etudiantRepository.save(e);
    }

    @WebMethod
    @Override
    @Path("/notes")
    public Etudiant addNote(String cne,float note){
        if(isExist(cne)){
            Etudiant etudiant=etudiantRepository.findById(cne).get();
            etudiant.getNotes().add(new Note(note,new Date().getYear()));
            etudiantRepository.save(etudiant);
            return etudiant;
        }
        return null;
    }



    @WebMethod
    @Override
    public List<Etudiant> getAll(){
        return etudiantRepository.findAll();
    }

    @WebMethod
    @Override
    public Etudiant removeEtudiant(String cne){
        Optional<Etudiant> e=etudiantRepository.findById(cne);
        if(e.isPresent()){
           etudiantRepository.delete(e.get());
            return e.get();
       }
        return null;
    }

    @WebMethod
    @Override
    public List<Note> getAllNoteByEtudiant(String cne){
        if(isExist(cne)) {
            return etudiantRepository.findById(cne).get().getNotes();
        }
        return null;
    }

    @WebMethod
    @Override
    public Etudiant getMajorant(){
        return etudiantRepository.findAll().stream().max(Comparator.comparing(
                etudiant -> etudiant.getNotes().stream().filter(note -> note.getAnnee()==119).findFirst().get().getMoyenne())).get();
    }

    public boolean isExist(String cne){
        return etudiantRepository.findById(cne).isPresent();
    }



}

