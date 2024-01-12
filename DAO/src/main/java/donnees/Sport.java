package donnees;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * POJO Sport
 * @author Eric
 */
public class Sport implements java.io.Serializable {
    
	private static final long serialVersionUID = -1479329647238860078L;

	private int codeSport;
    
    private String intitule;
    
    private Set<Discipline> disciplines;

    public void setCodeSport(int codeSport) {
        this.codeSport = codeSport;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public int getCodeSport() {
        return codeSport;
    }

    public String getIntitule() {
        return intitule;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void addDiscipline(Discipline disc) {
        this.disciplines.add(disc);
    }
    
    public void removeDiscipline(Discipline disc) {
        this.disciplines.remove(disc);
    }
    
    public Sport(int codeSport, String intitule, Set<Discipline> disciplines) {
        this.codeSport = codeSport;
        this.intitule = intitule;
        this.disciplines = disciplines;
    }

    public Sport() {
        this.disciplines = new HashSet<Discipline>();
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codeSport;
        hash = 67 * hash + Objects.hashCode(this.intitule);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sport other = (Sport) obj;
        if (this.codeSport != other.codeSport) {
            return false;
        }
        if (!Objects.equals(this.intitule, other.intitule)) {
            return false;
        }
        if (!Objects.equals(this.disciplines, other.disciplines)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sport{" + "codeSport=" + codeSport + ", intitule=" + intitule + '}';
    }
    
    
}
