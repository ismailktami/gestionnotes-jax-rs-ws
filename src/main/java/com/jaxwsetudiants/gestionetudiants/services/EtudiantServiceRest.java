package com.jaxwsetudiants.gestionetudiants.services;

import com.jaxwsetudiants.gestionetudiants.entities.Etudiant;
import com.jaxwsetudiants.gestionetudiants.entities.Note;
import com.jaxwsetudiants.gestionetudiants.repositories.EtudiantRepository;
import org.jvnet.hk2.internal.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import javax.jws.WebParam;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@Path("/serviceetudiant")
@Produces("application/json")
@Consumes("application/json")
public class EtudiantServiceRest implements Service{

    @Autowired
    private EtudiantRepository etudiantRepository;


    @Path("/addetudiant")
    @POST
    @Override
    public Etudiant addEtudiant( Etudiant e) {
        return etudiantRepository.save(e);
    }

    @GET
    @Path("/getAll")
    @Override
    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }

    @GET
    @Path("getMajorant")
    @Override
    public Etudiant getMajorant() {
        try {
            return etudiantRepository.findAll().stream().filter(etudiant -> etudiant.getNotes().size()>0).max(Comparator.comparing(etudiant -> etudiant.getNotes().stream().findFirst().get().getMoyenne())).get();
        }
        catch (Exception e){
            return  null;
        }
        }

    @Override
    @POST
    @Path("/notes/{cne}")
    public Etudiant addNote(@PathParam("cne") String cne,@QueryParam("note") float note) {
        if(!isExist(cne))
            return null;
        Etudiant e= etudiantRepository.findById(cne).get();
        e.getNotes().add(new Note(note,new Date().getYear()));
        return etudiantRepository.save(e);
    }

    @GET
    @Path("/notes/{cne}")
    @Override
    public List<Note> getAllNoteByEtudiant(@PathParam("cne") String cne) {
        if(isExist(cne)){
            return etudiantRepository.findById(cne).get().getNotes();
        }
        return null;
    }
    @DELETE
    @Path("/{cne}")
    @Override
    public Etudiant removeEtudiant(@PathParam("cne") String cne) {
        if(isExist(cne)){
            Etudiant e=etudiantRepository.findById(cne).get();
            etudiantRepository.delete(e);
            return e;
        }
      return null;
    }


    public boolean isExist(String cne){
        return etudiantRepository.existsById(cne);

    }

}
