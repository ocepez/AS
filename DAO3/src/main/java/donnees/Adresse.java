package donnees;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
public class Adresse implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Column(name = "rue")
    private String rue;
    @Column(name = "ville")
    private String ville;
 	@Column(name = "code_postal")
    private String codePostal;
	
   
    
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


	
	

}
