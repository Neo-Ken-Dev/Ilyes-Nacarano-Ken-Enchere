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
		</div>
	</nav>
	
	<!-- debut partie produit -->
	
	<div class="">

	    <div class="col-lg-12">
	      <h1>Nouvelle vente</h1>
		</div>	
		
		<div class="col-lg-5">
			<img class="img-responsive" src="../exemple_image.jpg">
		</div>
	
	  <div class="container">
	   <div class="row">	
		<div class="col-lg-6">	

			<div class="col-lg-12">
			  <h3>titre Article :</h3> 			  
			</div>
						
			<div class="col-lg-12">
               <h3>Description :</h3>
               <p> description de l'article</p>                             
            </div>
            
            <div class="col-lg-12">
			  <h3>Catégorie</h3> 
			  <h3>Catégorie</h3> 
			</div>
            
            <div class="col-lg-12">
              <h3>Meilleur offre :</h3>
              <h3>210 point par bob</h3>
            </div>
            
            <div class="col-lg-12">
              <h3>Mise à prix : </h3>
              <h3>185 points</h3>
            </div>
            
            <div class="col-lg-12">
              <h3>Fin de l'enchère : </h3>
              <h3>09/10/2018 </h3>
            </div>
                            
            <div class="col-lg-12">
              <h3>Retrait : </h3>
               <p> Adresse de retrait<br> de l'article</p>       
            </div>
            
           <div class="col-lg-12">                 
            <h3>Vendeur : </h3>
            <h3>pseudo vendeur </h3>
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