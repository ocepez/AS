package donnees;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;


/**
 * Servlet implementation class SportServlet
 */
@WebServlet("/CreationSportServlet")
public class CreationSportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    private Connection connection = null;
    private EntityManager em = null;
    private EntityTransaction trans = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportsPU");
		em = emf.createEntityManager();
		String action = request.getParameter("action");



		try {

			
			if (action.equals("creer")) {
				String operation = request.getParameter("intitule");	
				Sport pp = new Sport();
				pp.setIntitule(operation);			
				trans = em.getTransaction();
				trans.begin();
				em.merge(pp);
				trans.commit();
			    response.getWriter().println("Le sport " + operation + " a été créé avec succès.");

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
       


		//Query requete = em.createQuery("SELECT s FROM Sportif s");
	}

}
