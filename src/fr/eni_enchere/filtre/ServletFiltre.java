package fr.eni_enchere.filtre;

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
 * Servlet implementation class ServletFiltre
 */
@WebServlet("/ServletFiltre")
public class ServletFiltre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFiltre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String btnRadioChoisi = request.getParameter("filtering");
		String checkEncheresOuvertes = null;
		String checkMesEncheres = null;
		String checkMesEncheresRemportees = null;
		String checkMesVentesEnCours = null;
		String checkVentesNonDebutees = null;
		String checkVentesTerminees = null;
		String motDansRecherche = null;
		
		
		motDansRecherche = request.getParameter("keyword");
		
		
		if(btnRadioChoisi.equalsIgnoreCase("0")) {
			checkEncheresOuvertes = request.getParameter("encheresOuvertes");
			checkMesEncheres = request.getParameter("mesEncheres");
			checkMesEncheresRemportees = request.getParameter("mesEncheresRemportees");
		}
		
		if(btnRadioChoisi.equalsIgnoreCase("1")) {
			checkMesVentesEnCours = request.getParameter("mesVentesEnCours");
			checkVentesNonDebutees = request.getParameter("ventesNonDebutees");
			checkVentesTerminees = request.getParameter("ventesTerminees");
		}
		
		
		
		HttpSession session = request.getSession();	
		Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
		
		session.setAttribute("keyword", motDansRecherche);
		System.out.println("le mot dans la barre de recherche est : " + motDansRecherche);
		
		//int id = (int) session.getAttribute("id");	
		
		int id = utilisateur.getNoUtilisateur();
		System.out.println("noUtilisateur :" + id);
		
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
		
		
		
		
		
		
		
		
		
		response.sendRedirect(request.getContextPath()+"/user/accueil");
		
		
		//RequestDispatcher rd = request.getRequestDispatcher("/user/accueil");
		//rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
