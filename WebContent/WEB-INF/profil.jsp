<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Page Profil</title>
<link rel="stylesheet" href="style.css">
</head>

<body>


	<div class="container-fluid ">
		<div class="containerProfil">
			<div class="logo">
				<%@ include file="logoTop.jsp"%>
			</div>
			
			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Pseudo : </label> <input
					class="form-control inputEnlectureSeul" type="text"
					placeholder="blablabla..." readonly name="nom" id="nom">
			</div>

			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Nom : </label> <input
					class="form-control inputEnlectureSeul" type="text"
					placeholder="blablabla..." readonly name="nom" id="nom">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Prénom : </label> <input
					class="form-control inputEnlectureSeul" type="text"
					placeholder="blablabla..." readonly name="nom" id="nom">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Email : </label> <input
					class="form-control inputEnlectureSeul" type="text"
					placeholder="blablabla..." readonly name="nom" id="nom">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Téléphone : </label> <input
					class="form-control inputEnlectureSeul" type="text"
					placeholder="blablabla..." readonly name="nom" id="nom">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Rue : </label> <input
					class="form-control inputEnlectureSeul" type="text"
					placeholder="blablabla..." readonly name="nom" id="nom">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Code postal : </label> <input
					class="form-control inputEnlectureSeul" type="text"
					placeholder="blablabla..." readonly name="nom" id="nom">
			</div>
			<div class="enLigne col ">
				<label class="labelProfil" for="nom">Ville : </label> <input
					class="form-control inputEnlectureSeul" type="text"
					placeholder="blablabla..." readonly name="nom" id="nom">
			</div>
		</div>

	</div>

</body>

</html>