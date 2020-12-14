package fr.eni_enchere.dal;

import java.util.List;

import fr.eni_enchere.bo.ArticleVendus;

public interface ArticlesVendusDAO {
	
	public List<ArticleVendus> selectAll();

	public ArticleVendus ajouterProduit(ArticleVendus newArticle);

}
