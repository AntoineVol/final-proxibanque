package fr.gtm.final_proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.final_proxibanque.business.ClientService;
import fr.gtm.final_proxibanque.domain.Client;
import fr.gtm.final_proxibanque.domain.MauvaiseDateException;

/**
 * La class ClientController est un web service qui permet de dispatcher les
 * requetes HTTP concernant l'entité client
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	/**
	 * La methode addClient est un WebService déclenchant la création d'un nouveau
	 * client
	 *
	 * @param client
	 *            Client à persister en base de donnée
	 * @return Le client persisté
	 * @throws MauvaiseDateException
	 *             Erreur relever si la date de fin rensigné est antérieur à la date
	 *             de début de sondage
	 */
	@PostMapping({ "", "/" })
	public Client addClient(@RequestBody final Client client) throws MauvaiseDateException {
		return this.clientService.create(client);
	}

	/**
	 * La methode getClient est un WebService permettant de retourner un client à
	 * partir de son id
	 *
	 * @param id
	 *            Id du client recherché
	 * @return Le client enregistré en base correspondant à l'id
	 */
	@RequestMapping("/{id}")
	public Client getClient(@PathVariable final Integer id) {
		return this.clientService.read(id);
	}

}
