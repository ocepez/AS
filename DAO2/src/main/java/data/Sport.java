/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import donnees.Discipline;

/**
 *
 * @author ercar
 */

public class Sport implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Integer codeSport;
    private String intitule;
    private Set<Discipline> disciplineSet;

    public Sport() {
    }

    public Sport(Integer codeSport) {
        this.codeSport = codeSport;
    }

    public Integer getCodeSport() {
        return codeSport;
    }

    public void setCodeSport(Integer codeSport) {
        this.codeSport = codeSport;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Set<Discipline> getDisciplineSet() {
        return disciplineSet;
    }

    public void setDiscipline(Set<Discipline> disciplineSet) {
        this.disciplineSet = disciplineSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeSport != null ? codeSport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sport)) {
            return false;
        }
        Sport other = (Sport) object;
        if ((this.codeSport == null && other.codeSport != null) || (this.codeSport != null && !this.codeSport.equals(other.codeSport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Sport[ codeSport=" + codeSport + " ]";
    }
    
}