
import donnees.Sport;
import donnees.Discipline;

import javax.persistence.*;

public class TestJPA {

   public static void main(String argv[]) throws Exception {

      // charge le gestionnaire d'entit�s li� � l'unit� de persistance "SportsPU"
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportsPU");
      EntityManager em = emf.createEntityManager();
      System.out.println("PU charg�e");

      // r�cup�re le sport d'identifiant 1, affiche son intitul� et ses disciplines
      int cle = 1;
      Sport sport = em.find(Sport.class, cle);
      System.out.println("Le sport " + cle + " est " + sport.getIntitule());
      for (Discipline disc : sport.getDisciplineSet())
         System.out.println(" -> " + disc.getIntitule());
   }
}