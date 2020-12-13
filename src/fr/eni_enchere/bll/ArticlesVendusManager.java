package fr.eni_enchere.bll;

import java.util.List;

import fr.eni_enchere.bo.ArticleVendus;
import fr.eni_enchere.dal.ArticlesVendusDAO;
import fr.eni_enchere.dal.DAOFactory;

public class ArticlesVendusManager {
	
	private ArticlesVendusDAO daoArticleVendus;
	
	
	public ArticlesVendusManager() {
		daoArticleVendus = DAOFactory.getArticleVendusDAO();
	}




	public List<ArticleVendus> selectionArticlesVendus() {
		return daoArticleVendus.selectAll();
	}
	

}
