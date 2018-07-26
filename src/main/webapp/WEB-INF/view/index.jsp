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
	<h2>Sondage en cours</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div class="panel-body">

					<table class="table">

						<thead>

							<tr>

								<td>Date d'ouverture:</td>

								<td>Date de fermeture:</td>
								
								<td>Détails:</td>

							</tr>

						</thead>

						<tbody>

							<c:forEach var="survey" items="${surveys}">
							<c:url value="/details.html?id=" var="details" />
								<tr>

									<td><c:out value="${survey.startDate}" /></td>

									<td><c:out value="${survey.endDate}" /></td>
									
									<td><a href="${details}${survey.id}" class="btn btn-info">Voir détails</a></td>

	
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
							name="dateOuverture">
					</div>
					<div class="form-group">
						<label for="dateFermeturePrevisionnelle">Date de fermeture
							previsionnelle:</label> <input type="date" class="form-control"
							id="dateFermeturePrevisionnelle"
							name="dateFermeturePrevisionnelle">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-lg">
							Créer</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>