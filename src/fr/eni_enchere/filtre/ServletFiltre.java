package fr.eni_enchere.filtre;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		
		String btnRadioChoisi = request.getParameter("filtering");
		String checkEncheresOuvertes = null;
		String checkMesEncheres = null;
		String checkMesEncheresRemportees = null;
		String checkMesVentesEnCours = null;
		String checkVentesNonDebutees = null;
		String checkVentesTerminees = null;
		
		if(btnRadioChoisi.equalsIgnoreCase("0")) {
			checkEncheresOuvertes = request.getParameter("achat");
			System.out.println(checkEncheresOuvertes);
		}
		
		
		System.out.println("le btn radio selectionné est : "+ btnRadioChoisi);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
