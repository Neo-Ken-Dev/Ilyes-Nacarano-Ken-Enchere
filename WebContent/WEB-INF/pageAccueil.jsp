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
				<div class="navbar-header">
					<a class="navbar-brand" href="#">ENI-Encheres</a>
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
								<label for="categories">Catégorie :</label> <select
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
	</section>
</body>
</html>