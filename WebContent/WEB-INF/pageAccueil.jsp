<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- meta de base pour du bootstrap -->
<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="UTF-8">
<!-- Lien au .css -->
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<!-- CDN Google font "Chilanka" -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Chilanka&display=swap"
	rel="stylesheet">
<!-- CDN Bootstrap 3 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Accueil</title>
</head>
<body>
	<section id=page_accueil> 
		<nav class="navbar navbar-default">
			<div class="container-fluid">
			<c:if test="${!empty email2 }">
			<div class="alert alert-success" role="alert">Mot de passe réinitialisé !!! Merci de consulter votre boîte mail </div>			
			</c:if>

				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath}/">ENI-Encheres</a>
				</div>
				<div>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${pageContext.request.contextPath}/inscription">S'inscrire</a></li>
						<li><a href="${pageContext.request.contextPath}/connexion">Se connecter</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!--debut partie enchere-->
		<div class="container-fluid partie_recherche">
			<div class="row">
				<div class="">
					<h1>Liste des enchères</h1>
				</div>
				<div>
					<h2>Filtres :</h2>
				</div>
				<div>
					<form>
						<div class="col-sm-5">
							<div>
								<input class="barre_recherche" type="text"
									placeholder="🔍 Le nom de l'article contient" name="search">
							</div>
							<div class="liste_categories">
								<label for="categories">Catégorie :</label> 
								<select
									name="derouleur_categories" id="categories">
									<option>Informatique</option>
									<option>Ameublement</option>
									<option>Vêtement</option>
									<option>Sport&amp;Loisirs</option>
								</select>
							</div>
						</div>
						<div class="col-sm-6">
							<input type="submit" value="Rechercher"
								class="bouton_rechercher_accueil">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Liste enchères -->
		<!-- Aura besoin d'une boucle pour afficher tous les résultats de la BDD -->
		<div class="container-fluid resultats_encheres">
			<div class="row">
				<div class="col-xs-12 col-sm-6 enchere">
					<div class="col-xs-4 col-sm-4">
						<img class="img-responsive" src="exemple_image.jpg">
					</div>
					<div class="col-xs-8 col-sm-8">
						<h4>PC Gamer pour travailler</h4>
						<p>Prix: 210 point</p>
						<p>Fin des enchère: 10/08/2020</p>
						<p>Vendeur: jojo44</p>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 enchere">
					<div class="col-xs-4 col-sm-4">
						<img class="img-responsive" src="exemple_image.jpg">
					</div>
					<div class="col-xs-8 col-sm-8">
						<h4>PC Gamer pour travailler</h4>
						<p>Prix: 210 point</p>
						<p>Fin des enchère: 10/08/2020</p>
						<p>Vendeur: jojo44</p>
					</div>
				</div>
			</div>
		</div>
		<!-- *** Début code Ilyes *** -->
		<div class="container-fluid">
			<div class="titrePage">
				<p>Liste des enchères</p>
			</div>
			<form action="${pageContext.request.contextPath}/ServletFiltre">
				<div class="row divPrincipaleAvecFiltre">
					<div class=" col12 col-md-8  colonne1">
						<div class="row ">
							<h4 class="filtreTitre">
								<strong>Filtres :</strong>
							</h4>
						</div>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-text1"><i
									class="fas fa-search text-black" aria-hidden="true"></i></span>
							</div>
							<input class="form-control my-0 py-1" type="text"
								placeholder="Le nom de l'article contient" aria-label="Search">
						</div>
						<div class="row categorieContainer">
							<div class="titreCategorie">
								<label for="categories">Catégorie :</label>
							</div>
							<div class="btn-group divDropDown">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									Choisissez votre catégorie... <span class="caret"></span>
								</button>
								<ul class="dropdown-menu divDropDown">
									<c:forEach items="${listeCategories}" var="categorie">
										<option onclick="filterSelection(${categorie.noCategorie})">${categorie.libelle}</option>
									</c:forEach>
								</ul>
							</div>
						</div>
						<div class="row divRadioEtCheckbox">
							<div class="col divAchats col-12 col-md-4">
								<div class="radio">
									<label> <input type="radio" name="filtering" value="0"
										class="rbFilter" id="filteringON" checked="true"> <strong>Achats</strong>
									</label>
								</div>
								<div class="divCheckboxAchat">
									<div id="filterOnControls">
										<div class="checkbox">
											<label> <input type="checkbox"
												name="encheresOuvertes" value="encheresOuvertes">
												enchères ouvertes
											</label>
										</div>
										<div class="checkbox">
											<label> <input type="checkbox" name="mesEncheres"
												value="mesEncheres"> mes enchères
											</label>
										</div>
										<div class="checkbox">
											<label> <input type="checkbox"
												name="mesEncheresRemportees" value="mesEncheresRemportees">
												mes enchères remportées
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col divMesVentes col-12 col-md-4">
								<div class="radio">
									<label> <input name="filtering" type="radio" value="1"
										class="rbFilter" id="filteringOff"> <strong>Mes
											ventes</strong>
									</label>
								</div>
								<div class="divCheckMesVentes">
									<div id="filterOnControls">
										<div class="checkbox">
											<label> <input type="checkbox"
												name="mesVentesEnCours" value="mesVentesEnCours"
												disabled="true"> mes ventes en cours
											</label>
										</div>
										<div class="checkbox">
											<label> <input type="checkbox"
												name="ventesNonDebutees" value="ventesNonDebutees"
												disabled="true"> ventes non débutées
											</label>
										</div>
										<div class="checkbox">
											<label> <input type="checkbox" name="ventesTerminees"
												value="ventesTerminees" disabled="true"> ventes
												terminées
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12 col-md-4">
						<div class="colonne2">
							<div class="col btnRechercherConnecte">
								<button type="submit"
									class="btn btn-lg btn-primary btnRechercher shadow p-3 mb-5 ">
									Rechercher</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="alignerCarteProduit ">
				<c:forEach items="${listeArticlesVendus}" var="articleVendu">
					<div class="card-product filterDiv ${articleVendu.noCategorie}">
						<img
							src="https://d1eh9yux7w8iql.cloudfront.net/product_images/286281_fef79c54-2ee2-4427-819c-5e1f2ed0b392.jpg"
							class="" />
						<div class="">
							<h2 class="">${articleVendu.nomArticle}</h2>
							<p class="">Prix : ${articleVendu.prixVente} points</p>
							<p class="">Fin de l'enchère :
								${articleVendu.dateFinEncheres}</p>
							<p class="">Vendeur: ${utilisateur.pseudo}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- *** Fin code Ilyes *** -->
	</section>
</body>
</html>