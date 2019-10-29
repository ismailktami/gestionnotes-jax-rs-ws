package com.jaxwsetudiants.gestionetudiants.entities;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data  @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

public class Etudiant  implements Serializable {
    @Id
    private String cne;

    private String prenom;

    private String nom;

    @XmlTransient
    private Date dateNaissance;
    private int niveau;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
    List<Note> notes;


}

