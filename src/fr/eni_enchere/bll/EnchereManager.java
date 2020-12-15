package fr.eni_enchere.bll;

import java.sql.Date;

import fr.eni_enchere.bo.Encheres;
import fr.eni_enchere.dal.DAOFactory;
import fr.eni_enchere.dal.EnchereDAO;

public class EnchereManager {
	
	private EnchereDAO daoEncheres;
	
	public EnchereManager() {
		daoEncheres = DAOFactory.getEnchereDAO();
	}
	
	public void ajouterUneEnchere(Date dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
		//créer la condition d'ajout uniquement si l'enchère est plus haute que la précédente.
		
		Encheres newEnchere = new Encheres(dateEnchere, montantEnchere, noArticle, noUtilisateur);
		daoEncheres.ajouterEnchere(newEnchere);

	}
}
