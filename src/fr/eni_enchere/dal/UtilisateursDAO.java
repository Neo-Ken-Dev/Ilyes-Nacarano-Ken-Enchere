package fr.eni_enchere.dal;

import fr.eni_enchere.bo.Utilisateurs;

/**
 * 
 * @author Ken
 *Interface pour lister les méthode dont on aura besoin et que l'on va implémenter dans le FormInscriptionDAOJdbcImpl
 */
public interface UtilisateursDAO {

	void ajouterUtilisateur(Utilisateurs utilisateur);

	public Utilisateurs verifierUtilisateur(String pseudo, String motDePasse);
	
	public Utilisateurs selectionnerUtilisateurParId(int id);
	
	void modifierUtilisateur(Utilisateurs nouvellesInfoUser);
	
}
