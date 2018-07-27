<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value = "/css/style.css"></c:url>">
<body>
	<h1>Détails du sondage:</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div class="panel-body">
					<table class="table table-light">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Commentaires:</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="reponse" items="${responses}">
								<c:if test="${not empty reponse.comment}">
									<tr>
										<td>${reponse.comment}</td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col">
				<div class="row">
					<div class="card text-white bg-info mb-3" style="max-width: 18rem;min-width: 16rem">
						<div class="card-header">Nombre de réponse négatives:</div>
						<div class="card-body">
							<div class="testtoto">
								<span> <img class="negatif-icon"
									src="<c:url value = "/assets/negatif.svg"></c:url>">
								</span> <span class="taillenegatif">${negatif}</span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="card text-white bg-info mb-3" style="max-width: 18rem;min-width: 16rem">
						<div class="card-header">Nombre de réponse positives:</div>
						<div class="card-body">
							<div class="testtoto">
								<span> <img class="positif-icon"
									src="<c:url value = "/assets/positif.svg"></c:url>">
								</span>
								<spanc class="taillepositif">${positif}</span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="card text-white bg-info mb-3" style="max-width: 18rem; min-width: 16rem">
						<div class="card-header">Nouveaux clients inscrits:</div>
						<div class="card-body">
							<div class="testtoto">
								<span> <img class="newclient-icon"
									src="<c:url value = "/assets/newclient.svg"></c:url>">
								</span> <span class="taillenewclient">${nc}</span>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
		<c:url value="/index.html" var="index" />
		<a href="${index}" class="btn btn-info">Revenir à l'accueil</a>
	</div>
	</div>
	</div>
</body>
</html>