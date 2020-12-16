package fr.eni_enchere.dal;

import java.util.List;

import fr.eni_enchere.bo.ArticleVendus;

public interface ArticlesVendusDAO {
	
	public List<ArticleVendus> selectAll();

	public ArticleVendus ajouterProduit(ArticleVendus newArticle);
	
    public ArticleVendus selectById(int id);
    
    public ArticleVendus selectByIdWithInfoFromOtherTable(int id);

	public List<ArticleVendus> selectByFilter();
	
	public boolean update(ArticleVendus article);

	public List<ArticleVendus> selectByFilterLike();

}
