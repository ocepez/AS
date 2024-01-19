package sportsDAO;

import java.sql.Connection;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;

import donnees.Discipline;
import donnees.Sport;
import donnees.Sportif;

public class DAO_JPA_Sportif extends DAO_JPA<Sportif> {

	
	
    private Connection connection = null;
    private EntityManager em = null;
    private EntityTransaction trans = null;

	public DAO_JPA_Sportif() throws DAOException {
		super();
        this.connection = SQLConnection.getConnection();
        getEntityManager();

	}
	
	public EntityManager getEntityManager() {
		if(em == null) {
		      EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportsPU");
		      em = emf.createEntityManager();
		      
		}
		return em;
	}

	@Override
	public Sportif find(int id) throws DAOException {
		Sportif sport =  em.find(Sportif.class, id);
        
        return sport;
	}

	@Override
	public void create(Sportif disc) throws DAOException {
		try {
			trans = em.getTransaction();
			trans.begin();
			em.persist(disc);
			trans.commit();
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

	@Override
	public void update(Sportif disc) throws DAOException {
		try {
			trans = em.getTransaction();
			trans.begin();
			em.persist(disc);
			trans.commit();
		} catch(EntityExistsException e) {
			System.out.println("Sport update : Element déjà créé");
		
		} catch(IllegalArgumentException  e ) {
			System.out.println("Sport update : Argument mauvais");

			
		} catch(TransactionRequiredException f) {
			System.out.println("Sport update : Transaction non active");
			if(trans != null) {
				trans.rollback();
			}
		}

		}

	@Override
	public void delete(Sportif disc) throws DAOException {
		try {
			trans = em.getTransaction();
			trans.begin();
			em.remove(disc);
			trans.commit();
		} catch(IllegalArgumentException  e ) {
			System.out.println("Sport update : Argument mauvais");

			
		} catch(TransactionRequiredException f) {
			System.out.println("Sport update : Transaction non active");
		}
	}

}
