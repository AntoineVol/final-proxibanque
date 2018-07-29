package fr.gtm.finalproxibanque.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.finalproxibanque.business.ResponseService;
import fr.gtm.finalproxibanque.domain.MauvaiseDateException;
import fr.gtm.finalproxibanque.domain.Response;

/**
 * La class ResponseController est un web service qui permet de dispatcher les
 * requetes HTTP concernant l'entité Response
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@RestController
@RequestMapping("/response")
public class ResponseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseController.class);

	@Autowired
	private ResponseService responseService;

	/**
	 * La methode addResponse est un WebService permettant de persister en base de
	 * donnée une reponse en base de donnée
	 *
	 * @param response
	 *            Reponse à enregistré
	 * @return La réponse persisté en base de donnée
	 * @throws MauvaiseDateException
	 *             Erreur relever si la date de fin rensigné est antérieur à la date
	 *             de début de sondage
	 */

	@PostMapping({ "", "/" })
	public Response addResponse(@RequestBody final Response response) throws MauvaiseDateException {
		ResponseController.LOGGER
				.info("J'ajoute une réponse en base -- méthode addResponse -- class ResponseController");
		return this.responseService.create(response);
	}

}
