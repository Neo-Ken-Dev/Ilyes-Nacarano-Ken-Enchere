package fr.eni_enchere.bll;

import fr.eni_enchere.dal.ArticlesVendusDAO;
import fr.eni_enchere.dal.DAOFactory;
import fr.eni_enchere.dal.EnchereDAO;

public class EnchereManager {
	
private EnchereDAO daoEnchere;
	
	
	public EnchereManager() {
		daoEnchere = DAOFactory.getEnchereDAO();
	}
	
}
