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

import fr.eni_enchere.bll.CategoriesManager;
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
		session.setAttribute("id", id);
		System.out.println(id);
		
		CategoriesManager categoriesManager = new CategoriesManager();
		List<Categories> listeCategories =  categoriesManager.selectionCategories();
		request.setAttribute("listeCategories", listeCategories);
		System.out.println("Dans la servlet liste catégorie :" + listeCategories);
		
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
