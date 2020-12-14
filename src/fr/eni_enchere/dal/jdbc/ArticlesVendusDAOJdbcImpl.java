package fr.eni_enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni_enchere.bo.ArticleVendus;
import fr.eni_enchere.dal.ArticlesVendusDAO;
import fr.eni_enchere.dal.ConnectionProvider;

public class ArticlesVendusDAOJdbcImpl implements ArticlesVendusDAO {
	
	private  Connection connection;
	private static final String SELECT_ALL = "SELECT * FROM articles_vendus";
	private static final String INSERT_PRODUCT = "INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?)";
	
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

	@Override
	public ArticleVendus ajouterProduit(ArticleVendus newArticle) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStmtInsert = connection.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
			preparedStmtInsert.setString(1, newArticle.getNomArticle());
			preparedStmtInsert.setString(2, newArticle.getDescription());
			preparedStmtInsert.setDate(3, newArticle.getDateDebutEncheres());
			preparedStmtInsert.setDate(4, newArticle.getDateFinEncheres());
			preparedStmtInsert.setInt(5, newArticle.getPrixInitial());
			preparedStmtInsert.setInt(6, newArticle.getNoUtilisateur());	
			preparedStmtInsert.setInt(7, newArticle.getNoCategorie());	
			
			preparedStmtInsert.executeUpdate();
			
			//return and set noArticle created
			ResultSet rs = preparedStmtInsert.getGeneratedKeys();
			if(rs.next())
			{
				newArticle.setNoArticle(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newArticle;
		

	}

}
