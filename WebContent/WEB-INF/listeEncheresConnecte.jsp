<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Inscription</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!--Google Font Family-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <!--Pour icone-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
    <!--Custom Styles CSS-->
    <link rel="stylesheet" href="style.css">
    <!--Jquery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.0/jquery.min.js"></script>
</head>
<body>
<section id="enchereConnecte">


<nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Hamburger pour le format mobile -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">ENI-Enchères</a>
            </div>
            <div class="collapse navbar-collapse navbarDiv" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav divNavbar">
                    <li class="active"><a href="#">Enchères<span class="sr-only">(current)</span></a></li>
                    <li><a href="#">Vendre un article</a></li>
                    <c:if test="${!empty id }">
                    
                    <li><a href="${pageContext.request.contextPath}/user/monprofil?id=${id}">Mon profil</a></li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/deconnexion">Déconnexion</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="row titrePage">
            <p>Liste des enchères</p>
        </div>
        <div class="row divPrincipaleAvecFiltre">
            <div class="col-lg-6 col-md-6 colonne1">
                <div class="row ">
                    <h4 class="filtreTitre"><strong>Filtres :</strong></h4>
                </div>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-text1"><i class="fas fa-search text-black" aria-hidden="true"></i></span>
                    </div>
                    <input class="form-control my-0 py-1" type="text" placeholder="Le nom de l'article contient" aria-label="Search">
                </div>
                <div class="row categorieContainer">
                    <div class="titreCategorie">
                        <p>Catégorie : </p>
                    </div>
                    <div class="btn-group divDropDown">
                        <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="deviceSelector">
                            Toutes <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelled-by="dropdownMenu">
                        	<c:forEach items="${listeCategories}" var="categorie">                    	
                        	<li><a class="dropdown-item" href="javascript:void(0)" onclick="searchTableDevice(this.innerHTML)">${categorie.libelle}</a> </li>
                        	</c:forEach>
                        </ul>
                    </div>
                   
                </div>
                <div class="row divRadioEtCheckbox">
                    <div class="col divAchats">
                        <div class="radio">
                            <label>
                                <input type="radio" name="filtering" value="0" class="rbFilter" id="filteringON" checked="true">
                                <strong>Achats</strong>
                            </label>
                        </div>
                        <div class="divCheckboxAchat">
                            <div id="filterOnControls">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="achat" value="">
                                        enchères ouvertes
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="achat" value="">
                                        mes enchères
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="achat" value="" >
                                        mes enchères remportées
                                    </label>
                                </div>
                            </div>
                        </div>
   
                    </div>
                    <div class="col divMesVentes">
                        <div class="radio">
                            <label>
                                <input name="filtering" type="radio" value="1" class="rbFilter" id="filteringOff">
                                <strong>Mes ventes</strong>
                            </label>
                        </div>
                        <div class="divCheckMesVentes">
                            <div id="filterOnControls">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="mesVentes" value=""  disabled="true"  >
                                        mes ventes en cours
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="mesVentes" value=""  disabled="true"  >
                                        ventes non débutées
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="mesVentes" value=""  disabled="true" >
                                        ventes terminées
                                    </label>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 colonne2">
                <div class="col btnRechercherConnecte">
                    <div>
                        <button class="btn btn-lg btn-primary btnRechercher shadow p-3 mb-5 ">
                            Rechercher
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid card-product">
            <img src="https://d1eh9yux7w8iql.cloudfront.net/product_images/286281_fef79c54-2ee2-4427-819c-5e1f2ed0b392.jpg" />
            <div class="card-product-infos">
                <h2>PC Gamer pour travailler</h2>
                <p>Prix : 210 points</p>
                <p> Fin de l'enchère : 10/08/2018</p>
                <p>Vendeur: jojo44</p>
            </div>
        </div>
    </div>
    <!-- jQuery pour selectionner et deselectionner radioButton -->
	<script src="script.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous">
    </script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous">
    </script>

</section>
</body>
</html>