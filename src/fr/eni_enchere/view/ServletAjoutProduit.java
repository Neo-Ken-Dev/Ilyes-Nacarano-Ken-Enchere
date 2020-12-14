package fr.eni_enchere.view;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni_enchere.bll.ArticlesVendusManager;
import fr.eni_enchere.bll.RetraitManager;
import fr.eni_enchere.bo.ArticleVendus;

/**
 * Servlet implementation class ServletAjoutProduit
 */
@WebServlet("/user/mettre_en_vente")
public class ServletAjoutProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/AjoutProduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recup id utilisateur connecter
		HttpSession session = request.getSession();		
		int noUtilisateur = (int) session.getAttribute("id");	
		//test pour voir quel id on recupere
		System.out.println("verifier qu'on a une id : " + noUtilisateur);
		
		//int noUtilisateur = 38;
				
		String nomArticle = request.getParameter("article");
		String description = request.getParameter("description");
		
		//categorie on un numero dans la BDD convertir categori en numéro?
		int categorie = 0;
		
		if (request.getParameter("derouleur_categories").equals("Informatique")) {
			System.out.println("informatique");
			categorie = 1;
		}else if (request.getParameter("derouleur_categories").equals("Ameublement")){
			System.out.println("Ameublement");
			categorie = 2;
		}else if (request.getParameter("derouleur_categories").equals("Vêtement")){
			System.out.println("Vêtement");
			categorie = 3;
		}else if (request.getParameter("derouleur_categories").equals("Sport & Loisirs")){
			System.out.println("Sport & Loisirs");
			categorie = 1;
		}else {
			System.out.println("erreur pas de num de categorie");
		}
		
		//image ou l'ajouter dans la bdd?
		//String emailUser = request.getParameter("email");
		
		int prixInitial = Integer.parseInt(request.getParameter("price"));
		
		//date debut
		String dateDebutEncheres = request.getParameter("beginning-date");
        SimpleDateFormat formatdateDebut = new SimpleDateFormat("yyyy-MM-dd");      
        Date dateDebutEncheresBonFormat = null;
        java.sql.Date sqlDateDebut= null;
		try {
			dateDebutEncheresBonFormat = formatdateDebut.parse(dateDebutEncheres);		
			sqlDateDebut = new java.sql.Date(dateDebutEncheresBonFormat.getTime()); 
		} catch (ParseException e) {
			e.printStackTrace();
		}
    		
       //date fin
        String dateFinEncheres = request.getParameter("ending-date");
        SimpleDateFormat formatdateFin = new SimpleDateFormat("yyyy-MM-dd");      
        Date dateFinEncheresBonFormat = null;
        java.sql.Date sqlDateFin= null;
		try {
			dateFinEncheresBonFormat = formatdateFin.parse(dateFinEncheres);
			sqlDateFin = new java.sql.Date(dateFinEncheresBonFormat.getTime()); 
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/**
		 * ajouter le produit puis retourner le produit ajouter avec son noproduit. Puis utiliser ce retour pour ajouter les info dans la table retrait		
		 */
		ArticlesVendusManager ajouterArticles = new ArticlesVendusManager();
		ArticleVendus articleAjouterAvecNoArticle = ajouterArticles.ajouterArticle(nomArticle, description, sqlDateDebut, sqlDateFin, prixInitial, noUtilisateur, categorie);
		Integer idProduit = articleAjouterAvecNoArticle.getNoArticle();

		if (idProduit !=null) {		
			String streetUser = request.getParameter("street");
			String zipCodeUser = request.getParameter("zipCode");
			String cityUser = request.getParameter("city");
			
			RetraitManager ajouterRetrait = new RetraitManager();
			ajouterRetrait.ajouterRetrait(idProduit, streetUser, zipCodeUser, cityUser);
		}
	
		//renvoyer la réponse sur la page enchere connecte	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listeEncheresConnecte.jsp");
		rd.forward(request, response);	
		
	}

}
