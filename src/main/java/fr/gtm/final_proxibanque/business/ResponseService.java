package fr.gtm.final_proxibanque.business;

import org.springframework.stereotype.Service;
<<<<<<< Updated upstream
=======

import fr.gtm.final_proxibanque.dao.ResponseRepository;
>>>>>>> Stashed changes
import fr.gtm.final_proxibanque.domain.Response;

@Service
public class ResponseService extends CrudService<Response> {
<<<<<<< Updated upstream

=======
	
	public ResponseRepository getRepo() {
		return (ResponseRepository) this.repo;
	}
>>>>>>> Stashed changes
}
