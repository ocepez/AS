package sportsDAO;

import donnees.Discipline;
import donnees.Sport;

/**
 * Fabrique abstraite de DAO pour le schéma sports
 * @author Eric
 */
public abstract class SportsDAOFactory<T> {
    
    /**
     * @return le DAO pour la classe/table Sport.
     * @throws DAOException en cas de problème
     */
    public abstract T getDAOSport() throws DAOException;
    
    /**
     * @return le DAO pour la classe/table Discipline.
     * @throws DAOException en cas de problème
     */
    public abstract T getDAODiscipline() throws DAOException;
}
