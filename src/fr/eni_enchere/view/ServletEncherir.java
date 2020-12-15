package fr.eni_enchere.view;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni_enchere.bll.ArticlesVendusManager;
import fr.eni_enchere.bll.EnchereManager;
import fr.eni_enchere.bll.UtilisateursManager;
import fr.eni_enchere.bo.ArticleVendus;
import fr.eni_enchere.bo.Utilisateurs;

/**
 * Servlet implementation class ServletLoginPage
 */
@WebServlet("/encherir")
public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//recup info produit par id avec toutes les infos des autres table du sql
		//pour tester id en dure
		int id = 5; 
		ArticlesVendusManager articleManager = new ArticlesVendusManager();	
		ArticleVendus infoArticleAEncherir = articleManager.articleVendusWithAllInfo(id);

		request.setAttribute("ArticleAEncherir", infoArticleAEncherir);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageEncherir.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		//recup des info pour ajouter a la table encheres	
			//recup id utilisateur connecter
		/*HttpSession session = request.getSession();		
		int noUtilisateur = (int) session.getAttribute("id");*/
		int noUtilisateur = 39;
		//test pour voir quel id on recupere
	    System.out.println("verifier qu'on a une id : " + noUtilisateur);
	    
	    	//recu no_produit
	    int idProduit = 5;
	    
	    	//recu date enchere => date du jour
	    Date dateEnchere = new Date();
	    java.sql.Date sqlDateDebut = new java.sql.Date(dateEnchere.getTime()); 
	    System.out.println(dateEnchere);
	    System.out.println(sqlDateDebut);
	    
	      //recup montant
	    int montant_enchere = Integer.parseInt(request.getParameter("price"));
	   
	    //ajout dans la BDD
	    
	    EnchereManager enchereManager = new EnchereManager();
	    enchereManager.ajouterUneEnchere(sqlDateDebut, montant_enchere, idProduit, noUtilisateur);
	    
	    
	    
	}

}
