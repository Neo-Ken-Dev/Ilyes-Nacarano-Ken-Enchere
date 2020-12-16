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
	private static final String SELECT_BY_ID = "SELECT * FROM articles_vendus WHERE no_article= ?";
	private static final String INSERT_PRODUCT = "INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?)";
	private static final String SELECT_BY_ID_JOIN_ALL_TABLE ="SELECT * FROM ARTICLES_VENDUS \r\n" + 
			"   JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie\r\n" + 
			"   JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article\r\n" + 
			"     WHERE ARTICLES_VENDUS.no_article = ?";
	private static final String UPDATE_ARTICLE = "UPDATE articles_vendus SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_categorie = ? WHERE no_article = ?";
	 
	
	
	
	
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

	@Override
	public ArticleVendus selectById(int id) {
		loadDatabase();
		
		ArticleVendus ArticleVendus = null;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ArticleVendus = new ArticleVendus();
				ArticleVendus.setNoArticle(id);
				ArticleVendus.setNomArticle(rs.getString("nom_article"));
				ArticleVendus.setDescription(rs.getString("description"));
				ArticleVendus.setDateDebutEncheres(Date.valueOf(rs.getString("date_debut_encheres")));
				ArticleVendus.setDateFinEncheres(Date.valueOf(rs.getString("date_fin_encheres")));
				ArticleVendus.setPrixInitial(Integer.parseInt(rs.getString("prix_initial")));
				ArticleVendus.setNoCategorie(Integer.parseInt(rs.getString("no_categorie")));
							
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ArticleVendus;
	}

	@Override
	public ArticleVendus selectByIdWithInfoFromOtherTable(int id) {
		
		loadDatabase();
		
		ArticleVendus ArticleVendusWithAllInfo = null;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID_JOIN_ALL_TABLE);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ArticleVendusWithAllInfo = new ArticleVendus();
				ArticleVendusWithAllInfo.setNoArticle(id);
				ArticleVendusWithAllInfo.setNomArticle(rs.getString("nom_article"));
				ArticleVendusWithAllInfo.setDescription(rs.getString("description"));
				ArticleVendusWithAllInfo.setDateDebutEncheres(Date.valueOf(rs.getString("date_debut_encheres")));
				ArticleVendusWithAllInfo.setDateFinEncheres(Date.valueOf(rs.getString("date_fin_encheres")));
				ArticleVendusWithAllInfo.setPrixInitial(Integer.parseInt(rs.getString("prix_initial")));
				ArticleVendusWithAllInfo.setPrixVente(Integer.parseInt(rs.getString("prix_vente")));
				ArticleVendusWithAllInfo.setNoUtilisateur(Integer.parseInt(rs.getString("no_utilisateur")));
				ArticleVendusWithAllInfo.setLibelleCategorie(rs.getString("libelle"));
				ArticleVendusWithAllInfo.setRue(rs.getString("rue"));
				ArticleVendusWithAllInfo.setCode_postal(rs.getString("code_postal"));
				ArticleVendusWithAllInfo.setVille(rs.getString("ville"));						
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ArticleVendusWithAllInfo;
	}

	public List<ArticleVendus> selectByFilter() {
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
	public boolean update(ArticleVendus articleVendu) {
		loadDatabase();
		boolean updateDone = false;
		try {
			
			PreparedStatement stmt = connection.prepareStatement(UPDATE_ARTICLE);
			stmt.setString(1, articleVendu.getNomArticle());
			stmt.setString(2, articleVendu.getDescription());
			stmt.setDate(3, articleVendu.getDateDebutEncheres());
			stmt.setDate(4, articleVendu.getDateFinEncheres());
			stmt.setInt(5, articleVendu.getPrixInitial());
			stmt.setInt(6, articleVendu.getPrixVente());
			stmt.setInt(7, articleVendu.getNoCategorie());
			stmt.setInt(8, articleVendu.getNoArticle());
			
			System.out.println(articleVendu);
			stmt.executeUpdate();
			updateDone = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateDone;
		
	}

}
