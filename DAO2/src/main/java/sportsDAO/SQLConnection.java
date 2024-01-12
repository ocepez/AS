package sportsDAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Connexion � la base de BDD � partir d'un fichier XML de configuration pour JDBC.
 * @author Eric
 */
public class SQLConnection {

   /**
    * Configuration JDBC
    */
    private static ConfigJDBC config = null;
    
    /**
     * Connexion � la base de donn�es, pour r�aliser les requ�tes SQL
     */
    private static Connection connection = null;
    
    /**
     * Nom et emplacement du fichier XML de configuration de JDBC
     */
    private static String configFile = "src/main/java/sportsDAO/configJDBC.xml";
 
    /**
     * Charge le contenu du fichier XML de configuration.
     * @throws DAOException en cas de probl�me d'acc�s au fichier ou de 
     * lecture de son contenu
     */
    private static void loadConfigFile() throws DAOException {
        try {
            JAXBContext jc = JAXBContext.newInstance(sportsDAO.ConfigJDBC.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            config = (ConfigJDBC)unmarshaller.unmarshal(new File(configFile));
        }
        catch(Exception ex) {
            throw new DAOException("Impossible de charger la configuration JDBC ("+ex.getMessage()+")");
        }
    }
    
    /**
     * Renvoie la connexion vers le SGBD. Fonctionne en mode singleton : la connexion est instanci�e une seule fois.
     * Utilise le fichier de config JDBC par d�faut se trouvant dans le package sportsDAO des sources.
     * @return la connexion JDBC vers le SGBD
     * @throws DAOException en cas de probl�me
     */
    public static Connection getConnection() throws DAOException {
        try {
            if (config == null)loadConfigFile();
            if (connection == null)
                connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            return connection;
        } catch (SQLException ex) {
            throw new DAOException("Impossible de se connecter � la BDD ("+ex.getMessage()+")"); 
        }
    }
    
    /**
     * Renvoie la connexion vers le SGBD. Fonctionne en mode singleton : la connexion est instanci�e une seule fois.
     * Utilise le fichier de config JDBC pass� en param�tre.
     * @param configFile nom du fichier XML de connexion JDBC
     * @return la connexion JDBC vers le SGBD
     * @throws DAOException en cas de probl�me
     */
    public static Connection getConnection(String configFile) throws DAOException {
        SQLConnection.configFile = configFile;
        return SQLConnection.getConnection();
    }
    
    /**
     * Ferme la connexion actuellement ouverte avec le SGBD.
     */
    public static void closeConnection() {
        if (connection != null) try {
            connection.close();
        } catch (SQLException ex) {
            // rien � faire
        }
        connection = null;
    }
}
