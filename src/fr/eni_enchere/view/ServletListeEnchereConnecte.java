package fr.eni_enchere.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni_enchere.bll.ArticlesVendusManager;
import fr.eni_enchere.bll.CategoriesManager;
import fr.eni_enchere.bo.ArticleVendus;
import fr.eni_enchere.bo.Categories;
import fr.eni_enchere.bo.Utilisateurs;

/**
 * Servlet implementation class ServletListeEnchereConnecte
 */
@WebServlet("/user/accueil")

public class ServletListeEnchereConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();	
		Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
		
		int id = utilisateur.getNoUtilisateur();
		
		//Peut être supprimé, me sert de test
		session.setAttribute("id", id);

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
		doGet(request, response);	
	}

}
