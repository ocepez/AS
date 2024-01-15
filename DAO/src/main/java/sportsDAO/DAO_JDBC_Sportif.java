package sportsDAO;

import donnees.Discipline;
import donnees.Sport;
import donnees.Sportif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * DAO pour la classe/table Sport avec impl�mentation en JDBC.
 * @author Eric
 */
public class DAO_JDBC_Sportif extends DAO<Sportif> {



	private Connection connection = null;
	
	
    public DAO_JDBC_Sportif() throws DAOException {
		super();
        this.connection = SQLConnection.getConnection();
	}
    
    protected Set<Discipline> getDisciplinesSport(Sport sport) throws SQLException {
        Statement req = connection.createStatement();
        ResultSet res = req.executeQuery("select * from discipline where code_sport=" + sport.getCodeSport());

        //System.out.println(" Les disciplines du sport " + sport.getIntitule());
        HashSet<Discipline> disciplines = new HashSet<>();
        Discipline disc;
        while (res.next()) {
            //System.out.println(" -> " + res.getString(2));
            disc = new Discipline(res.getInt(1), res.getString(2), sport);
            disciplines.add(disc);
        }
        return disciplines;
    }

    @Override
    public Sportif find(int id) throws DAOException {
        try {
            Statement req = connection.createStatement();
            ResultSet res = req.executeQuery("select * from sportif where code_sportif=" + id);
            if (res.next()) {
                Sportif sport = new Sportif();
                sport.setCode_sportif(res.getInt(1));
                sport.setNom(res.getString(2));
                sport.setRue(res.getString(3));
                sport.setVille(res.getString(4));
                sport.setCode_postal(res.getString(5));
                return sport;
            } else {
                throw new DAOException("Le sport d'identifiant " + id + " n'existe pas");
            }
        } catch (Exception e) {
            throw new DAOException("Probl�me technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void create(Sportif sport) throws DAOException {
        try {
            Statement req = connection.createStatement();
            ResultSet res = req.executeQuery("select max(code_sportif) from sportif");
            res.next();
            int codeSport = res.getInt(1);
            codeSport++;
            
            if(sport.getCode_sportif() == 0) {
            	sport.setCode_sportif(codeSport);

            }


            PreparedStatement reqParam = connection.prepareStatement("insert into sportif values (?,?,?,?,?)");
            reqParam.setInt(1, sport.getCode_sportif());
            reqParam.setString(2, sport.getNom());
            reqParam.setString(3, sport.getRue());
            reqParam.setString(4, sport.getVille());
            reqParam.setString(5, sport.getCode_postal());

            int nb = reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Probl�me technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(Sportif sport) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("update `sportif` SET `nom` = ?, `rue` = ?, "
            		+ "`ville` = ?, `code_postal` = ? where code_sportif = ?");
        //    System.out.println(update `sportif` SET `nom` = ?, `rue` = ?, "
       //     		+ "`ville` = ?, `code_postal` = ? where code_sportif = "+sport.getCode_sportif());
            reqParam.setString(1, sport.getNom());
            reqParam.setString(2, sport.getRue());
            reqParam.setString(3, sport.getVille());
            reqParam.setString(4, sport.getCode_postal());
            reqParam.setInt(5, sport.getCode_sportif());
            int nb = reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Probl�me technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(Sportif sport) throws DAOException {
        try {
            // on efface le sportif           
        	PreparedStatement reqParam = connection.prepareStatement("delete from pratique where code_sportif = ?;");
            reqParam.setInt(1, sport.getCode_sportif());
            int nb = reqParam.executeUpdate();

        	PreparedStatement reqParam1 = connection.prepareStatement("delete from sportif where code_sportif = ?");
            reqParam1.setInt(1, sport.getCode_sportif());
            int nb1 = reqParam1.executeUpdate();
          


        } catch (Exception e) {
            throw new DAOException("Probl�me technique (" + e.getMessage() + ")");
        }
    }


}