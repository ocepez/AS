package sportsDAO;

import donnees.Discipline;
import donnees.Sport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * DAO pour la classe/table Discipline avec impl�mentation en JDBC.
 * @author Eric
 */
class DAO_JDBC_Discipline extends DAO<Discipline> {

    private Connection connection = null;
    
    
    protected Sport getSport(int id) throws SQLException {
        Statement req = connection.createStatement();
        ResultSet res = req.executeQuery("select * from sport where code_sport=" + id);

        //System.out.println(" Les disciplines du sport " + sport.getIntitule());
        Sport sport = new Sport();
        Discipline disc;
        while (res.next()) {
            //System.out.println(" -> " + res.getString(2));
            sport.setCodeSport(res.getInt(1));;
            sport.setIntitule(res.getString(2));

        }
        return sport;
    }
    
    @Override
    public Discipline find(int id) throws DAOException {
    	Discipline discipline = null;
    	try {
    		Statement req = connection.createStatement();
    		ResultSet res = req.executeQuery("select * from discipline where code_discipline="+id+"");
    		//tableau
            if (res.next()) {
            System.out.println("La discipline est "+id + "");
    			discipline = new Discipline();
    			discipline.setCodeDiscipline(res.getInt(1));
                System.out.println("1");
    			discipline.setIntitule(res.getString(2));
                System.out.println("2");
    			//discipline.setSportifSet(getSport(res.getInt(3)));
                System.out.println("1");
            }
    		

    	}catch(Exception e) {
            throw new DAOException("Probl�me technique (" + e.getMessage() + ")");
    	}    		
    	return discipline;
      //  throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void create(Discipline disc) throws DAOException {
        try {
            Statement req = connection.createStatement();
            ResultSet res = req.executeQuery("select max(code_discipline) from discipline");
            res.next();
            int codeDisc = res.getInt(1);
            codeDisc++;
            disc.setCodeDiscipline(codeDisc);

            req = connection.createStatement();
            int nb = req.executeUpdate("insert into discipline values (" + codeDisc + " , '" + disc.getIntitule() + "' , " + disc.getCodeSport() + ")");
			 System.out.println(" Discipline ajout�e : " + disc.getIntitule());

        } catch (Exception e) {
            throw new DAOException("Probl�me technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(Discipline data) throws DAOException {
    	try {
			Statement req = connection.createStatement();
			System.out.println("UPDATE `discipline` SET `code_discipline` = '"+data.getCodeDiscipline()+
					"', `intitule` = '"+data.getIntitule()+"', `code_sport` = '"
					+data.getCodeSport()+"' WHERE `discipline`.`code_discipline` = "
					+data.getCodeDiscipline()+"");
			req.executeUpdate("UPDATE `discipline` SET `code_discipline` = '"+data.getCodeDiscipline()+
					"', `intitule` = '"+data.getIntitule()+"', `code_sport` = '"
					+data.getCodeSport()+"' WHERE `discipline`.`code_discipline` = "
					+data.getCodeDiscipline()+"");
			 System.out.println(" Discipline modifi�e : " + data.getIntitule());

    	} catch (SQLException e) {
			// TODO Auto-generated catch block
            throw new DAOException("Probl�me technique (" + e.getMessage() + ")");
		}
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Discipline data) throws DAOException {
    	try {
			Statement req = connection.createStatement();
			req.execute("delete from  `discipline` WHERE `discipline`.`code_discipline` = "+data.getCodeDiscipline()+"");
			System.out.println(" Discipline supprim�e : " + data.getIntitule());

    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Probl�me technique (" + e.getMessage() + ")");

		}
    }

    public DAO_JDBC_Discipline() throws DAOException {
    	super();
        this.connection = SQLConnection.getConnection();
    }
    
}