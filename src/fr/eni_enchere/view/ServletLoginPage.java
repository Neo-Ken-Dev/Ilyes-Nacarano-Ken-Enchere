package fr.eni_enchere.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
			 
		
			Cookie[] cookies = request.getCookies();
			Cookie cookieUtilisateurPseudo = null;
			Cookie cookieUtilisateurMotDePasse = null;
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if(cookie.getName().equals("pseudo")) {
						cookieUtilisateurPseudo = cookie;
					};			
					if(cookie.getName().equals("motDePasse")) {
						cookieUtilisateurMotDePasse = cookie;
					};	
				}
			}
			
			if(cookieUtilisateurPseudo != null) {
				
				UtilisateursManager utilisateurManager = new UtilisateursManager();	
				Utilisateurs utilisateur = utilisateurManager.verifierUtilisateur(cookieUtilisateurPseudo.getValue(), cookieUtilisateurMotDePasse.getValue());

				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10);
				session.setAttribute("utilisateur", utilisateur);
				
				
				System.out.println(cookieUtilisateurPseudo.getName());
				System.out.println(cookieUtilisateurPseudo.getValue());
				System.out.println(cookieUtilisateurMotDePasse.getName());
				System.out.println(cookieUtilisateurMotDePasse.getValue());
				
				
		
				
				
				RequestDispatcher rd = request.getRequestDispatcher("user/accueil");
				rd.forward(request, response);
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/connexion.jsp");
				rd.forward(request, response);
			}
		
			//RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/connexion.jsp");
			//rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		String seSouvenirDeMoi = request.getParameter("seSouvenirDeMoi");
		String pageDestination;
	
		UtilisateursManager utilisateurManager = new UtilisateursManager();
		
		Utilisateurs utilisateur = utilisateurManager.verifierUtilisateur(pseudo, motDePasse);
		
		System.out.println(utilisateur);
		
		if (utilisateur != null) {
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10);
			session.setAttribute("utilisateur", utilisateur);			
		//	request.setAttribute("utilisateur", utilisateur);
			pageDestination = "user/accueil";
			
			if(seSouvenirDeMoi != null) {
				Cookie cookieUtilisateurPseudo = new Cookie("pseudo", pseudo);
				Cookie cookieUtilisateurMotDePasse = new Cookie("motDePasse", motDePasse);
				cookieUtilisateurPseudo.setMaxAge(200000);
				cookieUtilisateurMotDePasse.setMaxAge(200000);
				response.addCookie(cookieUtilisateurPseudo);
				response.addCookie(cookieUtilisateurMotDePasse);

				
			}
			
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
