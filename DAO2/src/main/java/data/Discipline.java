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

public class Discipline implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codeDiscipline;
    private String intitule;
    private Set<Sportif> sportifSet;

    private Sport codeSport;

    public Discipline() {
    }

    public Discipline(Integer codeDiscipline) {
        this.codeDiscipline = codeDiscipline;
    }

    public Integer getCodeDiscipline() {
        return codeDiscipline;
    }

    public void setCodeDiscipline(Integer codeDiscipline) {
        this.codeDiscipline = codeDiscipline;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Set<Sportif> getSportifSet() {
        return sportifSet;
    }

    public void setSportif(Set<Sportif> sportifSet) {
        this.sportifSet = sportifSet;
    }
    

    public void setSportif(Sportif sportifSet) {
        this.sportifSet.add(sportifSet);
    }

    public Sport getCodeSport() {
        return codeSport;
    }

    public void setCodeSport(Sport codeSport) {
        this.codeSport = codeSport;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeDiscipline != null ? codeDiscipline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discipline)) {
            return false;
        }
        Discipline other = (Discipline) object;
        if ((this.codeDiscipline == null && other.codeDiscipline != null) || (this.codeDiscipline != null && !this.codeDiscipline.equals(other.codeDiscipline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Discipline[ codeDiscipline=" + codeDiscipline + " ]";
    }
    
}
