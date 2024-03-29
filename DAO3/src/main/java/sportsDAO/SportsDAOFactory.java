package sportsDAO;

import donnees.Discipline;
import donnees.Sport;

/**
 * Fabrique abstraite de DAO pour le sch�ma sports
 * @author Eric
 */
public abstract class SportsDAOFactory<T> {
    
    /**
     * @return le DAO pour la classe/table Sport.
     * @throws DAOException en cas de probl�me
     */
    public abstract T getDAOSport() throws DAOException;
    
    /**
     * @return le DAO pour la classe/table Discipline.
     * @throws DAOException en cas de probl�me
     */
    public abstract T getDAODiscipline() throws DAOException;

    public abstract T getDAODiscipline1() throws DAOException ;
	public abstract T getDAOSport1() throws DAOException;
	public abstract T getDAOSportif1() throws DAOException;

}
