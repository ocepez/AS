package donnees;

import java.util.Objects;

/**
 * POJO Discipline
 * @author Eric
 */
public class Discipline implements java.io.Serializable {
    
	private static final long serialVersionUID = -5446896659949901895L;

	private int codeDiscipline;
    
    private String intitule;
    
    private Sport sport;

    public int getCodeDiscipline() {
        return codeDiscipline;
    }

    public void setCodeDiscipline(int codeDiscipline) {
        this.codeDiscipline = codeDiscipline;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Discipline(int codeDiscipline, String intitule, Sport sport) {
        this.codeDiscipline = codeDiscipline;
        this.intitule = intitule;
        this.sport = sport;
    }
    
    public Discipline() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codeDiscipline;
        hash = 97 * hash + Objects.hashCode(this.intitule);
        hash = 97 * hash + Objects.hashCode(this.sport);
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
        final Discipline other = (Discipline) obj;
        if (this.codeDiscipline != other.codeDiscipline) {
            return false;
        }
        if (!Objects.equals(this.intitule, other.intitule)) {
            return false;
        }
        if (!Objects.equals(this.sport, other.sport)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Discipline{" + "codeDiscipline=" + codeDiscipline + ", intitule=" + intitule + ", sport=" + sport + '}';
    }
    
}