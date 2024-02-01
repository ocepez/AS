/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donnees;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ercar
 */
@Entity
@Table(name = "sportif")
@NamedQueries({
    @NamedQuery(name = "Sportif.findAll", query = "SELECT s FROM Sportif s"),
    @NamedQuery(name = "Sportif.findByCodeSportif", query = "SELECT s FROM Sportif s WHERE s.codeSportif = :codeSportif"),
    @NamedQuery(name = "Sportif.findByNom", query = "SELECT s FROM Sportif s WHERE s.nom = :nom"),
    @NamedQuery(name = "Sportif.findByRue", query = "SELECT s FROM Sportif s WHERE s.adresse.rue = :rue"),
    @NamedQuery(name = "Sportif.findByVille", query = "SELECT s FROM Sportif s WHERE s.adresse.ville =:ville"),
    @NamedQuery(name = "Sportif.findByCodePostal", query = "SELECT s FROM Sportif s WHERE s.adresse.codePostal = :codePostal")})
public class Sportif implements Serializable {

    public Sportif() {
		super();
	    this.adresse = new Adresse();
	    this.disciplineSet = new HashSet<>();
	}

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_sportif")
    private Integer codeSportif;
  
    @Column(name = "nom")
    private String nom;
    
    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Embedded
    private Adresse adresse;

    @JoinTable(name = "pratique", joinColumns = {
        @JoinColumn(name = "code_sportif", referencedColumnName = "code_sportif")}, inverseJoinColumns = {
        @JoinColumn(name = "code_discipline", referencedColumnName = "code_discipline")})
    @ManyToMany
    private Set<Discipline> disciplineSet;

 

    public Integer getCodeSportif() {
		return codeSportif;
	}

	public void setCodeSportif(Integer codeSportif) {
		this.codeSportif = codeSportif;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Discipline> getDisciplineSet() {
		return disciplineSet;
	}

	public void setDisciplineSet(Set<Discipline> disciplineSet) {
		this.disciplineSet = disciplineSet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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