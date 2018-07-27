package fr.gtm.final_proxibanque.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.gtm.final_proxibanque.dao.ResponseRepository;
import fr.gtm.final_proxibanque.domain.Response;

/**
 * Le ResponseService est le service apparenté l'entité Response
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@Service
public class ResponseService extends CrudService<Response> {

	/**
	 * La methode ResponseRepository permet de recupérer le repository de la classe
	 * en forcant sont typage en "Repository"
	 *
	 * @return Le repository du Response
	 */
	public ResponseRepository getRepo() {
		return (ResponseRepository) this.repo;
	}

}
