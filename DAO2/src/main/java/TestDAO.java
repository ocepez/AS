/**
 * Fichier de test de fonctionnement de l'accès aux données via des DAO.
 * @author Eric
 */
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import donnees.*;
import sportsDAO.*;

public class TestDAO {

    public static void main(String argv[]) {
        try {
	   
	    // création des DAO via les fabriques
           // SportsDAOFactory factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JDBC);
            //SportsDAOFactory factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JSON);
            SportsDAOFactory factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JPA);

            //va renvoyer un DAO sport
           DAO_JPA<Discipline> daoDisc = (DAO_JPA<Discipline>)factory.getDAODiscipline();
           DAO_JPA<Sport> daoSport = (DAO_JPA<Sport>)factory.getDAOSport();
            
            // affichage du sport 1
            Sport sport = daoSport.find(1);
            System.out.println("Le sport d'id 1 est "+sport.getIntitule() + " et ses disciplines sont :");
            for (Discipline disc : sport.getDisciplineSet()) {
            	System.out.println(" --> "+disc.getIntitule());
            }
            
            // création d'un sport et de disciplines
            Sport s = new Sport();
            s.setIntitule("Peche");
            Discipline d1 = new Discipline();
            d1.setIntitule("Poisson x10");
            d1.setCodeSport(s);
            Discipline d2 = new Discipline();
            d2.setIntitule("Poisson 1kg");
            d2.setCodeSport(s);
            Set<Discipline> sse = new HashSet<Discipline>();
            sse.add(d1);
            sse.add(d2);
            s.setDiscipline(sse);            
            // enregistrement des objets dans la BDD
           // daoSport.create(s); 
           // daoDisc.create(d1);
           // daoDisc.create(d2);
            
            
            d2.setIntitule("Poisson 10kg");
            daoDisc.find(1);
            daoDisc.update(d2);
            daoDisc.delete(d2);
            s.setCodeSport(4);
            daoDisc.find(1);
            daoSport.update(s);
            daoSport.delete(s);
            System.out.println("La pèche et ses disciplines ont été ajoutées dans la BDD.");
            
           /* 
            
            // Modification d'un discipline       
            Discipline disc = daoDisc.find(10);
            System.out.println("Find : Le sport d'id 10 est "+disc.getIntitule() + "");

            Discipline dss = new Discipline();
            d1.setIntitule("3 vs 3");
            s = daoSport.find(4);
            d1.setCodeSport(s); 
            d1.setCodeDiscipline(10);
            System.out.println("Update : Le sport d'id 10 est "+disc.getIntitule() + "");
            daoDisc.update(d1);
            System.out.println("Fin Update : Le sport d'id 10 est "+disc.getIntitule() + "");
            
            //Supprimer un discipline
            // daoDisc.delete(d1);
            
            
            */
            


             
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}

