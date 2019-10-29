package com.jaxwsetudiants.gestionetudiants.entities;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Data  @Getter @Setter  @NoArgsConstructor
@Entity
public class Note  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float moyenne;
    private int annee;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @XmlTransient
    private Etudiant etudiant;

    public Note(float m,int anne){
        this.moyenne=m;this.annee=anne;
    }

}
