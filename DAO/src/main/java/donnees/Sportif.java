package donnees;
//c'est un POJO 
public class Sportif {
	
	private int code_sportif;
	
	private String nom;
	
	private String rue;
	
	private String ville;
	
	private String code_postal;

	public int getCode_sportif() {
		return code_sportif;
	}

	public void setCode_sportif(int code_sportif) {
		this.code_sportif = code_sportif;
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

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

}