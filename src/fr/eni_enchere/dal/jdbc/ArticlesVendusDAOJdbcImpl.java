package fr.eni_enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni_enchere.bo.ArticleVendus;
import fr.eni_enchere.dal.ArticlesVendusDAO;
import fr.eni_enchere.dal.ConnectionProvider;

public class ArticlesVendusDAOJdbcImpl implements ArticlesVendusDAO {
	
	private  Connection connection;
	private static final String SELECT_ALL = "SELECT * FROM articles_vendus";
	
	private void loadDatabase() {		
		try {
			//on établie la connexion, on crée la requete.
			connection = ConnectionProvider.getConnection();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<ArticleVendus> selectAll() {
		loadDatabase();
		List<ArticleVendus> listeArticles = new ArrayList<ArticleVendus>();
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {			
				listeArticles.add(new ArticleVendus(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(listeArticles);
		return listeArticles;
	}

}
