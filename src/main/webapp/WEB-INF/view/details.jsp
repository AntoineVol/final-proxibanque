<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<body>
	<h2>Détails:</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div class="panel-body">

					<table class="table">

						<thead>

							<tr>

								<td>Commentaire:</td>


							</tr>

						</thead>

						<tbody>

							<c:forEach var="reponse" items="${responses}">

								<tr>

									<td><c:out value="${reponse.comment}" /></td>

	
								</tr>

							</c:forEach>


						</tbody>

					</table>

				</div>

			</div>
			<div class="col">
				<span>Nombre de réponse négatives: ${negatif}</span>
			</div>
			<div class="col">
				<span>Nombre de réponse positives: ${positif}</span>
			</div>
			<div class="col">
				<span>Nombre de nouveaux clients inscrits: ${nc}</span>
			</div>
		</div>
	</div>
	<c:url value="/index.html" var="index" />
	<a href="${index}" class="btn btn-info">Revenir à l'accueil</a>
</body>
</html>