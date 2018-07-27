<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value = "/css/style.css"></c:url>">
<body>
	<h2>Détails:</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div class="panel-body">
					<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
						<div class="card-header">Commentaires:</div>
						<c:forEach var="reponse" items="${responses}">
							<c:if test="${not empty reponse.comment}">
								<p class="card-text">${reponse.comment}</p>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
					<div class="card-header">Nombre de réponse négatives:</div>
					<div class="card-body">
						<span>
							<img class="negatif-icon" src="<c:url value = "/assets/negatif.svg"></c:url>">
						</span>
						<span class="taillenegatif">${negatif}</span>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
					<div class="card-header">Nombre de réponse positives:</div>
					<div class="card-body">
						<span>
							<img class="positif-icon" src="<c:url value = "/assets/positif.svg"></c:url>">
						</span>
						<span>${positif}</span>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
					<div class="card-header">Nouveaux clients inscrits:</div>
					<div class="card-body">
						<span>
							<img class="newclient-icon" src="<c:url value = "/assets/newclient.svg"></c:url>">
						</span>
						<span>${nc}</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<c:url value="/index.html" var="index" />
	<a href="${index}" class="btn btn-info">Revenir à l'accueil</a>
</body>
</html>