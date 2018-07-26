<<<<<<< Updated upstream
package fr.gtm.final_proxibanque.business;

import org.springframework.stereotype.Service;

import fr.gtm.final_proxibanque.dao.ResponseRepository;

import fr.gtm.final_proxibanque.domain.Response;

@Service
public class ResponseService extends CrudService<Response> {

	
	public ResponseRepository getRepo() {
		return (ResponseRepository) this.repo;
	}

}
=======
package fr.gtm.final_proxibanque.business;

import org.springframework.stereotype.Service;


import fr.gtm.final_proxibanque.dao.ResponseRepository;

import fr.gtm.final_proxibanque.domain.Response;

@Service
public class ResponseService extends CrudService<Response> {

	
	public ResponseRepository getRepo() {
		return (ResponseRepository) this.repo;
	}

}
>>>>>>> Stashed changes
