package fr.eni_enchere.bll;

import fr.eni_enchere.bo.Utilisateurs;
import fr.eni_enchere.dal.DAOFactory;
import fr.eni_enchere.dal.UtilisateursDAO;

/**
 * @author ken
Manager de Utilisateurs
 */

public class UtilisateursManager {
	
	private static UtilisateursDAO daoUtilisateur;
	/**
	 *  Constructeur de UtilisateursManager qui retourne une instance de UtilisateursDAOJdbcImpl
	 * afin de ne pas créer une instance à chaque appel de méthode mais uniquement au moment de l'intanciation
	 * UtilisateursManager
	 * @param newUtilisateur
	 */
	public UtilisateursManager() {
		this.daoUtilisateur = DAOFactory.getUtilisateursDAO();
	}
	
	public Utilisateurs addNewUser(String pseudoUser, String prenomUser, String nomUser, String emailUser, String phoneUser, String streetUser, String zipCodeUser, String cityUser, String passwordUser) {
		Utilisateurs utilisateur = new Utilisateurs(pseudoUser, nomUser, prenomUser, emailUser, phoneUser, streetUser, zipCodeUser, cityUser, passwordUser, 10, 0);
		daoUtilisateur.ajouterUtilisateur(utilisateur);
		return utilisateur;
	}

	public static  Utilisateurs verifierUtilisateur(String pseudo, String motDePasse) {
			
		return daoUtilisateur.verifierUtilisateur(pseudo, motDePasse);

	}

	
	
}
