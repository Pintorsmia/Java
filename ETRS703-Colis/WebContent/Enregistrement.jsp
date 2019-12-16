<%@page import="amazon.java.Colis"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enregistrement Colis</title>
</head>
<body>
	

	<form method="post" action="EnregistrementServlet">
		<label>poids :</label><input name="poids" value="${monColis.numero}" /> 
		<label>valeur :</label><input name="valeur" value="${monColis.valeur}" /> 
		<label>origine :</label><input name="origine" value="${monColis.origine}" /> 
		<label>destination :</label><input name="destination" value="${monColis.destination}" />
		<button type="submit">Enregistrer</button>
		<button type="cancel">Annuler</button>
	</form>
	<br>
	<p> Numero du colis cree</p>
	<p>${monColis.numero}</p>
	
</body>
</html>
