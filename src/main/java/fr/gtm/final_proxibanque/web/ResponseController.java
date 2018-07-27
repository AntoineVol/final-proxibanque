package fr.gtm.final_proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.final_proxibanque.business.ResponseService;
import fr.gtm.final_proxibanque.domain.MauvaiseDateException;
import fr.gtm.final_proxibanque.domain.Response;

/**
 * La class ResponseController est un web service qui permet de dispatcher les
 * requetes HTTP concernant l'entité Response
 *
 * @author Kamir Elsisi & Steven Roman & Antoine Volatron
 *
 */
@RestController
@RequestMapping("/response")
public class ResponseController {

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
	 */
	@PostMapping({ "", "/" })
	public Response addResponse(@RequestBody final Response response) throws MauvaiseDateException {

		return this.responseService.create(response);
	}

}
