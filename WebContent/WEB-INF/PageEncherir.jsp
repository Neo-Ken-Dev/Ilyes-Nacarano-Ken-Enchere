<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
<link rel="stylesheet" href="style.css">
</head>
<body>
  <section id="page_encherir">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">ENI-Encheres</a>
			</div>					
		</div>
	</nav>
	
	<!-- debut partie produit -->
	
	<div class="">

	    <div class="col-lg-12 titre">
	      <h1>Détail vente</h1>
		</div>	
		
		<div class="col-lg-3">
			<img class="img-responsive" src="exemple_image.jpg">
		</div>
	
	  <div class="container-fluid">
	   <div class="row">	
		<div class="col-lg-8 col-sm-12 col-xs-12">	

			<div class="col-lg-12">
			  <h3>${ArticleAEncherir.nomArticle }</h3> 			  
			</div>
						
			<div class="col-lg-12 ">
               <h3 class="col-lg-5 ">Description :</h3>
               <p class="col-lg-7 ">${ArticleAEncherir.description }</p>                             
            </div>
            
            <div class="col-lg-12">
			  <h3 class="col-lg-5">Catégorie</h3> 
			  <h3 class="col-lg-7">${ArticleAEncherir.libelleCategorie }</h3> 
			</div>
            
            <div class="col-lg-12">
              <h3 class="col-lg-5">Meilleur offre :</h3>
              <h3 class="col-lg-7">210 point par bob</h3>
            </div>
            
            <div class="col-lg-12">
              <h3 class="col-lg-5">Mise à prix : </h3>
              <h3 class="col-lg-7">${ArticleAEncherir.prixInitial }  points</h3>
            </div>
            
            <div class="col-lg-12">
              <h3 class="col-lg-5">Fin de l'enchère : </h3>
              <h3 class="col-lg-7">${ArticleAEncherir.dateFinEncheres } </h3>
            </div>
                            
            <div class="col-lg-12">
              <h3 class="col-lg-5">Retrait : </h3>
              <p class="col-lg-7">${ArticleAEncherir.rue}<br>${ArticleAEncherir.code_postal} ${ArticleAEncherir.ville}</p>       
            </div>
            
           <div class="col-lg-12">                 
            <h3 class="col-lg-5">Vendeur : </h3>
            <h3 class="col-lg-7">pseudo vendeur </h3>
           </div>  
           
           <div class="col-lg-12">
             <form method="post" action="" role="form">
              <label for="price">Ma proposition : </label>
              <input id="price" type="number" name="price" class="form-control" min="1" step="10" value="220">
           
           	  <div class="col-md-6">
			    <input type="submit" class="btn-primary buttonEnregistrer" value="Enchérir">
		      </div> 
		     </form>        
           </div>

        </div>	
       </div>
	  </div>  	  
	</div>		
  </section>
</body>
</html>