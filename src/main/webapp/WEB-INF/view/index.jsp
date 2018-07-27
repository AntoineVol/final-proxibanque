<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value = "/css/style.css"></c:url>">
<body>
	<h1 class="titre">Sondage en cours</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div class="panel-body">

					<table class="table">

						<thead>

							<tr>

								<td>Id:</td>

								<td>Date d'ouverture:</td>
								
								<td>Date de fermeture prévisionnelle:</td>

								<td>Date de fermeture:</td>

								<td>Détails:</td>

							</tr>

						</thead>

						<tbody>

							<c:forEach var="survey" items="${surveys}">
								<c:url value="/details.html?id=" var="details" />
								<tr>
									<td><c:out value="${survey.id}" /></td>

									<td><c:out value="${survey.startDate}" /></td>
									
									<td><c:out value="${survey.expectedDate}" /></td>

									<td><c:out value="${survey.endDate}" /></td>

									<td><a href="${details}${survey.id}" class="btn btn-info">Voir
											détails</a></td>


								</tr>

							</c:forEach>


						</tbody>

					</table>

				</div>

			</div>
			<div class="col">
				<h4>Créer un sondage</h4>
				<form method="post">
					<div class="form-group">
						<label for="dateOuverture">Date d'ouverture:</label> <input
							type="date" class="form-control" id="dateOuverture"
							name="dateOuverture" required>
					</div>
					<div class="form-group">
						<label for="dateFermeturePrevisionnelle">Date de fermeture
							previsionnelle:</label> <input type="date" class="form-control"
							id="dateFermeturePrevisionnelle"
							name="dateFermeturePrevisionnelle" required>
					</div>
					<div class="form-group">
						<c:if test="${isRunning==false}">
						<button type="submit" class="btn btn-success btn-lg">Créer</button>
						<c:if test="${not empty message}">
							<div class="alert alert-danger" role="alert">${message}</div>
							</c:if>
						
						</c:if>
						<c:if test="${isRunning==true}">
						<button type="submit" class="btn btn-default" disabled="disabled">Créer</button>
						<div class="alert alert-warning" role="alert">Vous ne pouvez pas créer un nouveau sondage, car il y a déjà un sondage en cours</div>
						</c:if>
					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2">
				<form action="" method="post">
					<div class="form-group">
						<label for="dateFermeture">Date de fermeture:</label> <input
						type="date" class="form-control" id="dateFermeture"
						name="dateFermeture" required>
					</div>
					<div class="form-group">
						<c:if test="${isRunning==true}">
							<button type="submit" class="btn btn-success btn-lg">Fermer le sondage</button>
							<c:if test="${not empty message}">
							<div class="alert alert-danger" role="alert">${message}</div>
							</c:if>
						</c:if>
						<c:if test="${isRunning==false}">
							<button type="submit" class="btn btn-default" disabled="disabled">Fermer le sondage</button>
							<div class="alert alert-warning" role="alert">Vous ne pouvez pas fermer de sondage, car il n'y a pas de sondage en cours</div>
						</c:if>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>