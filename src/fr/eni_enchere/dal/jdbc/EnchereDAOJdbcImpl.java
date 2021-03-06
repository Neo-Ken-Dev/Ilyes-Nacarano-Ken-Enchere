package fr.eni_enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni_enchere.bo.Encheres;
import fr.eni_enchere.dal.ConnectionProvider;
import fr.eni_enchere.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private  Connection connection;
	private static final String INSERT_ENCHERES = "INSERT INTO ENCHERES (no_utilisateur,no_article,date_enchere,montant_enchere) VALUES (?,?,?,?)";
	
	private void loadDatabase() {		
		try {
			//on établie la connexion, on crée la requete.
			connection = ConnectionProvider.getConnection();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterEnchere(Encheres newEnchere) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStmtInsert = connection.prepareStatement(INSERT_ENCHERES);
			preparedStmtInsert.setInt(1, newEnchere.getNoUtilisateur());
			preparedStmtInsert.setInt(2, newEnchere.getNoArticle());
			preparedStmtInsert.setDate(3, newEnchere.getDateEnchere());
			preparedStmtInsert.setInt(4, newEnchere.getMontantEnchere());
			
			preparedStmtInsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	

}
