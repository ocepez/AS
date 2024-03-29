package sportsDAO;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Iterator;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;

import donnees.Discipline;
import donnees.Sport;
import donnees.Sportif;

public class DAO_JPA_All<E> extends DAO_JPA<E> implements Serializable {


	
    private Connection connection = null;
    private EntityManager em = null;
    private EntityTransaction trans = null;

	public DAO_JPA_All() throws DAOException {
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

	public E find(int id, Class e) throws DAOException {
        E sport = (E) em.find(e, id);
 
        return sport;
	}

	@Override
	public void create(E disc) throws DAOException {
		try {
			trans = em.getTransaction();
			trans.begin();
			em.merge(disc);
			trans.commit();
		} catch(EntityExistsException e) {
			System.out.println("Sport create : Element d�j� cr��");
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
	public void update(E disc) throws DAOException {
		try {
			trans = em.getTransaction();
			trans.begin();
			em.merge(disc);
			trans.commit();
		} catch(EntityExistsException e) {
			System.out.println("Sport update : Element d�j� cr��");
		
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
	public void delete(E sport) throws DAOException {
		try {
			trans = em.getTransaction();
			trans.begin();
		/*	if(disc.getDisciplineSet() != null && !disc.getDisciplineSet().isEmpty()) {
				Iterator<Discipline> iter = disc.getDisciplineSet().iterator();
				while(iter.hasNext()) {
					Discipline discc = iter.next();
					em.remove(discc);
				}
			}*/
			em.remove(sport);
			trans.commit();
		} catch(IllegalArgumentException  e ) {
			System.out.println("Sport delete : Argument mauvais");
			
		} catch(TransactionRequiredException f) {
			System.out.println("Sport delete : Transaction non active");
		}
	}

	@Override
	public E find(int id) throws DAOException {
		
		return null;
	}


}
