package donnees;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;


/**
 * Servlet implementation class SportServlet
 */
@WebServlet("/CreationSportifServlet")
public class CreationSportifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    private EntityManager em = null;
    private EntityTransaction trans = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportsPU");
		em = emf.createEntityManager();
		String nom = request.getParameter("nom");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String code = request.getParameter("codePostal");
		String action = request.getParameter("action");
		//PrintWriter out =  response.getWriter();

		try {

			
			if (action.equals("creer")) {
				Sportif pp = new Sportif();
				pp.setNom(nom);
				Adresse adr = new Adresse();
				adr.setCodePostal(code);
				adr.setRue(rue);
				adr.setVille(ville);
				pp.setAdresse(adr);
				
				trans = em.getTransaction();
				trans.begin();
				em.merge(pp);
				trans.commit();
			    response.getWriter().println("Le sportif " + nom + " a été créé avec succès.");

				}


		} catch(EntityExistsException e) {
			System.out.println("Sport create : Element déjà créé");
		} catch(IllegalArgumentException  e ) {
			System.out.println("Sport create : Argument mauvais");

			
		} catch(TransactionRequiredException f) {
			System.out.println("Sport create : Transaction non active");
			if(trans != null) {
				trans.rollback();
			}
		}
	}

}
