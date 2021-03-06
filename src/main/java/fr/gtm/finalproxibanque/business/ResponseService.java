package fr.gtm.finalproxibanque.business;

import org.springframework.stereotype.Service;
import fr.gtm.finalproxibanque.dao.ResponseRepository;
import fr.gtm.finalproxibanque.domain.Response;

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
	 * en forçant sont typage en "Repository"
	 *
	 * @return Le repository du Response
	 */

	public ResponseRepository getRepo() {
		return (ResponseRepository) this.repo;
	}
	
	
	
	/**
	 * méthode pour enregistrer un nouveau avis au sondage (response) en base de données
	 * @param response 
	 * 					l'avis au sondage à enregistrer
	 * @return l'avis (response)
	 */
	public Response create(final Response response) {
		
		return this.repo.save(response);
	}
	
	
}
