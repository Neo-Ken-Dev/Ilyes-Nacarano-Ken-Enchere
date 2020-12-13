package fr.eni_enchere.view;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.eni_enchere.bll.ArticlesVendusManager;
import fr.eni_enchere.bll.CategoriesManager;
import fr.eni_enchere.bo.ArticleVendus;
import fr.eni_enchere.bo.Categories;
import fr.eni_enchere.bo.Utilisateurs;
import fr.eni_enchere.dal.ConnectionProvider;

/**
 * Servlet implementation class ServletListeEnchereConnecte
 */
@WebServlet("/user/accueil")
@MultipartConfig(maxFileSize = 16177215)    // taille max de l'image 16MB

public class ServletListeEnchereConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		
		Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
		int id = utilisateur.getNoUtilisateur();
		
		request.setAttribute("utilisateur", utilisateur);
		//Peut être supprimé, me sert de test
		session.setAttribute("id", id);
		System.out.println(id);
		
		CategoriesManager categoriesManager = new CategoriesManager();
		List<Categories> listeCategories =  categoriesManager.selectionCategories();
		request.setAttribute("listeCategories", listeCategories);
		System.out.println("Dans la servlet liste catégorie :" + listeCategories);
		
		ArticlesVendusManager articlesVendusManager = new ArticlesVendusManager();
		List<ArticleVendus> listeArticlesVendus = articlesVendusManager.selectionArticlesVendus();
		request.setAttribute("listeArticlesVendus", listeArticlesVendus);
		System.out.println("Dans la servlet liste articles vendus : " + listeArticlesVendus);
		

		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listeEncheresConnecte.jsp");
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Test pour image
		/*
		Connection connection;
		final String SELECT_ALL = "SELECT * FROM categories";
		 String message = null;  // message will be sent back to client
		
		InputStream inputStream = null; // input stream of the upload file

		
		
		// obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        
        try {
			connection = ConnectionProvider.getConnection();
			
			String sql = "INSERT INTO articles_vendus (nom_article,description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, photo) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
 
            statement.setString(1, "Cours de math");
            statement.setString(2, "bla bla bla");
            statement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            statement.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
            statement.setInt(5, 200);
            statement.setInt(6, 300);
            statement.setInt(7, 2);
            statement.setInt(8, 2);
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBinaryStream(9, inputStream);
            }
            
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		*/
		doGet(request, response);
		
	}

}
