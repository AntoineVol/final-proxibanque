<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<body>
	<h2>Sondage en cours</h2>
	<h3>Créer un sondage</h3>
	<div class="container">
	<form action="" method="post">
		<div class="form-group">
			<label for="dateOuverture">Date d'ouverture:</label>
			<input type="date"
				class="form-control" id="dateOuverture" name="dateOuverture">
		</div>
		<div class="form-group">
			<label for="dateFermeturePrevisionnelle">Date de fermeture previsionnelle:</label>
			<input type="date" class="form-control"
				id="dateFermeturePrevisionnelle" name="dateFermeturePrevisionnelle">
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-success btn-lg">
				Créer</button>
		</div>
	</form>
	</div>
</body>
</html>