package fr.eni_enchere.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_enchere.bll.UtilisateursManager;
import fr.eni_enchere.bo.Utilisateurs;

/**
 * Servlet implementation class ServletProfilPage
 */
@WebServlet("/user/profil")
public class ServletProfilPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
=======


>>>>>>> branch 'main' of https://github.com/Neo-Ken-Dev/Ilyes-Nacarano-Ken-Enchere.git

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
			
		UtilisateursManager utilisateursManager = new UtilisateursManager();
		
=======

		UtilisateursManager utilisateursManager = new UtilisateursManager();

>>>>>>> branch 'main' of https://github.com/Neo-Ken-Dev/Ilyes-Nacarano-Ken-Enchere.git
		int id = Integer.parseInt(request.getParameter("id"));
		Utilisateurs utilisateur = UtilisateursManager.selectionnerUtilisateurParId(id);


		request.setAttribute("utilisateur", utilisateur);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/profil.jsp");
		rd.forward(request, response);

	}

<<<<<<< HEAD
=======

>>>>>>> branch 'main' of https://github.com/Neo-Ken-Dev/Ilyes-Nacarano-Ken-Enchere.git
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
