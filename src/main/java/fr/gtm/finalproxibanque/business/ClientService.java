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
	
	


	/**
	 * La methode ClientRepository permet de récupérer le repository de la classe en
	 * forçant son typage en "Repository"
	 *
	 * @return Le repository du Client
	 */
	public ClientRepository getRepo() {
		return (ClientRepository) this.repo;
	}
	
	
	/**
	 * Trouver un client à partir de son numéro d'identification
	 * @param clientNumber
	 * 					 le numéro du client
	 * @return le client 
	 */
	public Client findByClientNumber(final String clientNumber) {
		
		return this.getRepo().findByClientNumber(clientNumber);
	}
	
	
	/**
	 * méthode pour enregistrer un nouveau client en base de données
	 * @param client
	 * 				le client à enregitrer
	 * @return le client 
	 */
	public Client create(final Client client) {
		
		return this.repo.save(client);
		
	}
	
	
	
}
