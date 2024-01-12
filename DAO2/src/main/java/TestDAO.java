/**
 * Fichier de test de fonctionnement de l'acc�s aux donn�es via des DAO.
 * @author Eric
 */
import donnees.*;
import sportsDAO.*;

public class TestDAO {

    public static void main(String argv[]) {
        try {
	 /*   
	    // cr�ation des DAO via les fabriques
            SportsDAOFactory factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JDBC);
            //SportsDAOFactory factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JSON);
            //SportsDAOFactory factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JPA);

            //va renvoyer un DAO sport
            //
            DAO<Sport> daoSport = factory.getDAOSport(); 
            DAO<Discipline> daoDisc = factory.getDAODiscipline();
            
            // affichage du sport 1
            Sport sport = daoSport.find(1);
            System.out.println("Le sport d'id 1 est "+sport.getIntitule() + " et ses disciplines sont :");
            for (Discipline disc : sport.getDisciplineSet()) {
            	System.out.println(" --> "+disc.getIntitule());
            }
            
            // cr�ation d'un sport et de disciplines
            Sport s = new Sport();
            s.setIntitule("P�tanque");
            Discipline d1 = new Discipline();
            d1.setIntitule("Triplette");
            d1.setCodeSport(s);
            Discipline d2 = new Discipline();
            d2.setIntitule("Doublette");
            d2.setCodeSport(s);
            s.addDiscipline(d1);
            s.addDiscipline(d2);
            
            // enregistrement des objets dans la BDD
            //daoSport.create(s); 
           // daoDisc.create(d1);
           // daoDisc.create(d2);
                    
            System.out.println("La p�tanque et ses disciplines ont �t� ajout�es dans la BDD.");
            
            
            
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
