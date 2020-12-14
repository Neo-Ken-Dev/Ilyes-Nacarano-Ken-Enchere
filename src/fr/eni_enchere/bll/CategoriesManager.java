package fr.eni_enchere.bll;

import java.util.List;

import fr.eni_enchere.bo.Categories;
import fr.eni_enchere.dal.CategoriesDAO;
import fr.eni_enchere.dal.DAOFactory;
import fr.eni_enchere.dal.UtilisateursDAO;

public class CategoriesManager {
	
	private  CategoriesDAO daoCategorie;
	/**
	 *  Constructeur de UtilisateursManager qui retourne une instance de UtilisateursDAOJdbcImpl
	 * afin de ne pas créer une instance à chaque appel de méthode mais uniquement au moment de l'intanciation
	 * UtilisateursManager
	 * @param newUtilisateur
	 */
	public CategoriesManager() {
		daoCategorie = DAOFactory.getCategoriesDAO();
	}
	public List<Categories> selectionCategories() {
		return daoCategorie.selectAll();
	}
	
	
	
	
	
	

}
