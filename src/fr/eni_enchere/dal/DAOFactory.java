package fr.eni_enchere.dal;

import fr.eni_enchere.dal.jdbc.ArticlesVendusDAOJdbcImpl;
import fr.eni_enchere.dal.jdbc.CategoriesDAOJdbcImpl;
import fr.eni_enchere.dal.jdbc.RetraitDAOJdbcImpl;
import fr.eni_enchere.dal.jdbc.UtilisateursDAOJdbcImpl;
/**
 * @author ken
 * 
 * Class pour instancier les DAOJdbcImpl
 * en abstract pour ne pas avoir besoin de l'instancier pour l'utiliser.
 *
 */

public abstract class DAOFactory {
	
	public static UtilisateursDAO getUtilisateursDAO() {
		return new UtilisateursDAOJdbcImpl();
	}
	
	public static CategoriesDAO getCategoriesDAO() {
		return new CategoriesDAOJdbcImpl();
	}

	public static ArticlesVendusDAO getArticleVendusDAO() {		
		return new ArticlesVendusDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {		
		return new RetraitDAOJdbcImpl();
	}
	
	
}
