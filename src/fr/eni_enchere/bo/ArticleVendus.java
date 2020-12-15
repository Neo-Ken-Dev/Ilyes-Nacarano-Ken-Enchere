package fr.eni_enchere.bo;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ArticleVendus {
	
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	private List<ArticleVendus> articles = new ArrayList<>();
	
	//ajout d'attribut pour créer un objet regroupant les table ARTICLES_VENDUS / CATEGORIES et RETRAITS => voire constructeur Constructeur table réunie
	private String libelleCategorie;
	private String rue;
	private String code_postal;
	private String ville;
	
	//CONSTRUCTORS -----------------------------------------
	public ArticleVendus() {
		super();
	}

	//constructeur pour ajouter un nouvelle article depuis la page AjoutArticle.jsp
	public ArticleVendus(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int prixInitial, int noUtilisateur, int noCategorie) {
		this.nomArticle = nomArticle;
		this.description = description; 
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	
	
	public ArticleVendus(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int prixInitial, int prixVente, int noUtilisateur, int noCategorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	

	
	public ArticleVendus(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int prixInitial, int prixVente, int noUtilisateur, int noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	
	//Constructeur table réunie  pour créer un objet regroupant les table ARTICLES_VENDUS / CATEGORIES et RETRAITS
	public ArticleVendus(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int prixInitial, int noUtilisateur, String libelleCategorie, String rue, String code_postal, String ville) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.noUtilisateur = noUtilisateur;
		
		this.libelleCategorie = libelleCategorie;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;

	}
	

	//GETTERS ET SETTERS -----------------------------------------

	public int getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}


	public String getNomArticle() {
		return nomArticle;
	}


	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}


	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}


	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}


	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}


	public int getPrixInitial() {
		return prixInitial;
	}


	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}


	public int getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}


	public int getNoUtilisateur() {
		return noUtilisateur;
	}


	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}


	public int getNoCategorie() {
		return noCategorie;
	}


	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	
	
	
	public List<ArticleVendus> getArticles() {
		return articles;
	}
	
	
	public void setArticles(List<ArticleVendus> articles) {
		this.articles = articles;
	}
	

	public String getLibelleCategorie() {
		return libelleCategorie;
	}

	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}



	
	//Méthode to String -----------------------------------------
	

	@Override
	public String toString() {
		return "ArticleVendus [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie="
				+ noCategorie + ", articles=" + articles + "]";
	}



		
	
	
	

}
