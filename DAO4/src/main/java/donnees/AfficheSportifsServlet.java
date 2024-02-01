package donnees;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mongoPojo.Federation;
import mongoPojo.Sportif;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


/**
 * Servlet implementation class AfficheSportifs
 */
public class AfficheSportifsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	MongoCollection<mongoPojo.Sportif> sportifs;
	MongoCollection<Federation> federations;
	
	List<Sportif> sportifs1 = new ArrayList<Sportif>() ;
	
    public AfficheSportifsServlet() {
        super();
    	CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
		
		ConnectionString connectionString = new ConnectionString("mongodb://obiwan.univ-brest.fr:27017");
		MongoClient mongoClient = MongoClients.create(connectionString);
		MongoDatabase database = mongoClient.getDatabase("pezennec").withCodecRegistry(pojoCodecRegistry);
		System.out.println("Connexion établie\n");
		
		federations = database.getCollection("federations", Federation.class);
		sportifs = database.getCollection("sportifs", Sportif.class);
    }
	public List<Sportif> getListeSportifs() {
		
		List<Sportif> result = new ArrayList<Sportif>();
		
		for(mongoPojo.Sportif fed : sportifs.find()) {
			
			mongoPojo.Sportif sp = new mongoPojo.Sportif();
			sp.setAdresse(fed.getAdresse());
			sp.setAge(fed.getAge());
			sp.setGenre(fed.getGenre());
			//sp.setId(0);
			sp.setMarie(fed.getMarie());
			sp.setNom(fed.getNom());
			sp.setPrenom(fed.getPrenom());
			
			if(sp.getDisciplines() == null) {
				sp.setDisciplines(new ArrayList<String>());
			}
			
			for(String disc : fed.getDisciplines()) 
				{
				sp.getDisciplines().add(disc);
				}
			
		
		}
		return (List<Sportif>) result;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("doGet\n");
		
		String operation = request.getParameter("operation");
		if(operation != null) {
			System.out.println("operation\n");

		if (operation.equals("listeSportifMongo")) {
			System.out.println("listeSportifMongo\n");

			// rï¿½cupï¿½re la liste des sportifs et l'associe ï¿½ la requï¿½te HTTP
			request.setAttribute("sportifs", this.getListeSportifs());
			// forwarde la requï¿½te ï¿½ la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/afficheSportifsMongo.jsp")
				.forward(request, response);
		} else if (operation.equals("listeDisciplines")) {
			//request.setAttribute("Disciplines", this.getListeDisciplines());
			//request.setAttribute("yo", this.getListeSports());

			//getServletConfig().getServletContext().getRequestDispatcher("/creationDisc.jsp").forward(request, response);
			System.out.println("Attribut inconnu");

			
		}
		}else {
			System.out.println("Operation vide");
		}
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
