<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modifier compte</title>
<!-- Bootstrap-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<!--Google Font Family-->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
<!--Custom Styles CSS-->
<link rel="stylesheet" href="../style.css">
</head>
<body>
  <section id=ajout-produit>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">ENI-Encheres</a>
			</div>
			
			<div>
			  <h1>Nouvelle vente</h1>
			</div>			
		</div>
	</nav>
	
	<!-- debut partie produit -->
	
	<div class="container-fluid">
	  <div class="row">
		<div class="col-xs-4 col-sm-4">
			<img class="img-responsive" src="exemple_image.jpg">
		</div>
		
		<div class="col-lg-10 col-lg-offset-1">
		
          <form id="ajout-produit-form" method="post" action="" role="form">

			<div class="col-md-6">
			  <label for="article">Article :</label> 
			  <input id="article" type="text" name="article" class="form-control" placeholder="Votre pseudo" value="">
			</div>
						
			<div class="col-md-6">
               <label for="description">Description :</label>
               <textarea id="description" name="description" class="form-control" placeholder="" rows="4"></textarea>                             
            </div>
            
            <div class="col-md-6">
			  <label for="categorie">Catégorie</label> 
			    <select name="derouleur_categories" id="categorie" class="form-control">
				  <option>Informatique</option>
				  <option>Ameublement</option>
				  <option>Vêtement</option>
				  <option>Sport&amp;Loisirs</option>
				</select>
			</div>
            
            <div class="col-md-6">
              <label for="file">Photo de l'article</label>
              <input id="file" type="file" name="email" class="form-control" value="">
            </div>
            
            <div class="col-md-6">
              <label for="price">Mise à prix : </label>
              <input id="price" type="number" name="price" class="form-control" min="1" step="10" value="140">
            </div>
            
            <div class="col-md-6">
              <label for="beginning-date">Début de l'enchère : </label>
              <input type="date" id="beginning-date" name="beginning-date" placeholder="  /  /  " class="form-control" min="2018-01-01" max="2025-12-31" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            </div>
                            
            <div class="col-md-6">
              <label for="ending-date">Fin de l'enchère : </label>
              <input type="date" id="ending-date" name="ending-date" placeholder="  /  /  " class="form-control" min="2018-01-01" max="2025-12-31" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            </div>
                            
            <fieldset>
    		  <legend>Retrait</legend>
    		  <div class="col-md-6">
			    <label for="street">Rue :</label> 
			    <input id="street" type="text" name="street" class="form-control" placeholder="" value="">
			  </div>
			  <div class="col-md-6">
			    <label for="zipCode">Code postal :</label> 
			    <input id="zipCode" type="text" name="zipCode" class="form-control" placeholder="" value="">
			  </div>
			  <div class="col-md-6">
			    <label for="city">Ville :</label> 
			    <input id=""city"" type="text" name=""city"" class="form-control" placeholder="" value="">
			 </div>          
            </fieldset>
                            
            <div class="col-md-12 divBtn">
			  <div class="col-md-6">
			    <input type="submit" class="btn-primary buttonEnregistrer" value="Enregistrer">
		      </div>
			  <div class="col-md-6 ">
			    <input type="reset" class="btn-primary buttonAnnuler" value="Annuler" onclick="location.href='index.html'">
			  </div>
			</div> 
			
          </form>
         </div>	  
	  </div>
	</div>		
  </section>
</body>
</html>