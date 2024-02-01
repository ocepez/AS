package donnees;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class SportServlet
 */
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public List<Sportif> getListeSportifs() {
		// requ�te JPQL pour r�cup�rer les sportifs dans la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportsPU");
		EntityManager em = emf.createEntityManager();
		Query requete = em.createQuery("SELECT s FROM Sportif s");
		return (List<Sportif>) requete.getResultList();
	}
	
	public List<Discipline> getListeDisciplines() {
		// requ�te JPQL pour r�cup�rer les sportifs dans la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportsPU");
		EntityManager em = emf.createEntityManager();
		Query requete = em.createQuery("SELECT s FROM Discipline s");
		return (List<Discipline>) requete.getResultList();
	}
	
	public List<Sport> getListeSports() {
		// requ�te JPQL pour r�cup�rer les sportifs dans la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportsPU");
		EntityManager em = emf.createEntityManager();
		Query requete = em.createQuery("SELECT s FROM Sport s");
		return (List<Sport>) requete.getResultList();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation != null) {

		if (operation.equals("listeSportif")) {
			// r�cup�re la liste des sportifs et l'associe � la requ�te HTTP
			request.setAttribute("sportifs", this.getListeSportifs());
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/afficheSportifs.jsp")
				.forward(request, response);
		} else if (operation.equals("listeDisciplines")) {
			request.setAttribute("Disciplines", this.getListeDisciplines());
			request.setAttribute("yo", this.getListeSports());

			getServletConfig().getServletContext().getRequestDispatcher("/creationDisc.jsp").forward(request, response);
			
			
		}
		}else {
			System.out.println("Operation vide");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
