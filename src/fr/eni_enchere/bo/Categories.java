package fr.eni_enchere.bo;

/**
 * @author mak_t
 *
 */
public class Categories {
	
	private int noCategorie;
	private String libelle;
	
	
	public Categories() {
		super();
	}

	
	public Categories(String libelle) {
		super();
		this.libelle = libelle;
	}


	public Categories(int no_categorie, String libelle) {
		super();
		this.noCategorie = no_categorie;
		this.libelle = libelle;
	}


	public int getNo_categorie() {
		return noCategorie;
	}


	public void setNo_categorie(int no_categorie) {
		this.noCategorie = no_categorie;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "Categories [no_categorie=" + noCategorie + ", libelle=" + libelle + "]";
	}
	
	
}
