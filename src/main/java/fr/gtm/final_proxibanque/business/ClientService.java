package fr.gtm.final_proxibanque.business;

import org.springframework.stereotype.Service;

import fr.gtm.final_proxibanque.dao.ClientRepository;
import fr.gtm.final_proxibanque.domain.Client;

@Service
public class ClientService extends CrudService<Client> {
	public ClientRepository getRepo() {
		return (ClientRepository) this.repo;
	}
}
