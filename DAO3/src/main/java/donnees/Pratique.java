package donnees;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "pratique")
public class Pratique {
	
    @Column(name = "sportifs")
	ArrayList<Sportif> sportifs;
	
    @Column(name = "disciplines")
	ArrayList<Discipline> disciplines;

	public ArrayList<Sportif> getSportifs() {
		return sportifs;
	}

	public void setSportifs(ArrayList<Sportif> sportifs) {
		this.sportifs = sportifs;
	}

	public ArrayList<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(ArrayList<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	public Pratique() {
		super();
	}
	
	
	

}
