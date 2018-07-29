package fr.gtm.finalproxibanque.business;

import org.springframework.stereotype.Service;

import fr.gtm.finalproxibanque.dao.ClientRepository;
import fr.gtm.finalproxibanque.domain.Client;

/**
 * Le ClientService est le service apparenté l'entité Client
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@Service
public class ClientService extends CrudService<Client> {
	
	
	public Client findByClientNumber(final String clientNumber) {

		return this.getRepo().findByClientNumber(clientNumber);
	}

	/**
	 * La methode ClientRepository permet de recupérer le repository de la classe en
	 * forcant sont typage en "Repository"
	 *
	 * @return Le repository du Client
	 */
	public ClientRepository getRepo() {
		return (ClientRepository) this.repo;
	}
}
