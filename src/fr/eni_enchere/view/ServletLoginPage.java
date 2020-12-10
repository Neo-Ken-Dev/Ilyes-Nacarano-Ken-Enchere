package fr.eni_enchere.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni_enchere.bll.UtilisateursManager;
import fr.eni_enchere.bo.Utilisateurs;


/**
 * Servlet implementation class ServletLoginPage
 */
@WebServlet("/connexion")
public class ServletLoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/connexion.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		String pageDestination;
		
		UtilisateursManager utilisateurManager = new UtilisateursManager();
		
		Utilisateurs utilisateur = UtilisateursManager.verifierUtilisateur(pseudo, motDePasse);
		
		System.out.println(utilisateur);
		
		if (utilisateur != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);			
		//	request.setAttribute("utilisateur", utilisateur);
			pageDestination = "user/accueil";
			
		}
		
		else {
			String messageErreur = "Oops!! Pseudo/Mot de passe invalide";
			request.setAttribute("messageErreur", messageErreur);
			pageDestination = "WEB-INF/connexion.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(pageDestination);
		rd.forward(request, response);
	
	}

}
