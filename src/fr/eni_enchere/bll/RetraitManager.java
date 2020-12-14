package fr.eni_enchere.bll;

import fr.eni_enchere.bo.Retraits;
import fr.eni_enchere.dal.DAOFactory;
import fr.eni_enchere.dal.RetraitDAO;

public class RetraitManager {

	private  RetraitDAO daoCategorie;
	/**
	 *  Constructeur de UtilisateursManager qui retourne une instance de UtilisateursDAOJdbcImpl
	 * afin de ne pas créer une instance à chaque appel de méthode mais uniquement au moment de l'intanciation
	 * UtilisateursManager
	 * @param newUtilisateur
	 */
	public RetraitManager() {
		daoCategorie = DAOFactory.getRetraitDAO();
	}
	
	public void ajouterRetrait(int idProduit, String streetUser, String zipCodeUser, String cityUser) {
		Retraits retrait = new Retraits(idProduit, streetUser, zipCodeUser, cityUser);
		daoCategorie.ajouterRetrait(retrait);
	}
}
