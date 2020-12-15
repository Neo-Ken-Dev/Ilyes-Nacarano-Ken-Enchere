package fr.eni_enchere.bll;


import java.sql.Date;
import java.util.List;

import fr.eni_enchere.bo.ArticleVendus;
import fr.eni_enchere.dal.ArticlesVendusDAO;
import fr.eni_enchere.dal.DAOFactory;

public class ArticlesVendusManager {
	
	private ArticlesVendusDAO daoArticleVendus;
	
	
	public ArticlesVendusManager() {
		daoArticleVendus = DAOFactory.getArticleVendusDAO();
	}

   public ArticleVendus ajouterArticle(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres, int prixInitial, int noUtilisateur, int noCategorie) {
	   ArticleVendus newArticle = new ArticleVendus(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, noUtilisateur, noCategorie);
	   ArticleVendus newArticleAjouterAvecID = daoArticleVendus.ajouterProduit(newArticle);
   
	   return newArticleAjouterAvecID;	   
   }

	public List<ArticleVendus> selectionArticlesVendus() {
		return daoArticleVendus.selectAll();
	}
	
	public ArticleVendus selectionArticlesVendusById(int id) {
		return daoArticleVendus.selectById(id);
	}
	

}
