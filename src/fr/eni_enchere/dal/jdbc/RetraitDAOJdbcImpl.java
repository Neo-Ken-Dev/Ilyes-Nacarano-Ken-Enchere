package fr.eni_enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni_enchere.bo.Retraits;
import fr.eni_enchere.dal.ConnectionProvider;
import fr.eni_enchere.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO{

	private  Connection connection;	
	private static final String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article,rue,code_postal,ville) VALUES (?,?,?,?)";

	
	private void loadDatabase() {		
		try {
			//on établie la connexion, on crée la requete.
			connection = ConnectionProvider.getConnection();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void ajouterRetrait(Retraits retrait) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStmtInsert = connection.prepareStatement(INSERT_RETRAIT);
			preparedStmtInsert.setInt(1, retrait.getNoArticle());
			preparedStmtInsert.setString(2, retrait.getRue());
			preparedStmtInsert.setString(3, retrait.getCodePostal());
			preparedStmtInsert.setString(4, retrait.getVille());
		
			preparedStmtInsert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
