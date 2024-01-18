/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.Set;


/**
 *
 * @author ercar
 */
public class Sportif implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer codeSportif;
    private String nom;
    private String rue;
    private String ville;
    private String codePostal;

    private Set<Discipline> disciplineSet;

    public Sportif() {
    }

    public Sportif(Integer codeSportif) {
        this.codeSportif = codeSportif;
    }

    public Integer getCodeSportif() {
        return codeSportif;
    }

    public void setCodeSportif(Integer codeSportif) {
        this.codeSportif = codeSportif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Set<Discipline> getDisciplineSet() {
        return disciplineSet;
    }

    public void setDisciplineSet(Set<Discipline> disciplineSet) {
        this.disciplineSet = disciplineSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeSportif != null ? codeSportif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sportif)) {
            return false;
        }
        Sportif other = (Sportif) object;
        if ((this.codeSportif == null && other.codeSportif != null) || (this.codeSportif != null && !this.codeSportif.equals(other.codeSportif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Sportif[ codeSportif=" + codeSportif + " ]";
    }
    
}