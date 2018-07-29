package fr.gtm.finalproxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.finalproxibanque.domain.Client;

/**
 * L'interface ClientRepository permet de lier l'entité Client à un JPA
 * repository
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	/**
	 * méthode de recherche d'un client par son numéro d'identification
	 * @param clientNumber
	 * 						le numéro d'identification du client
	 * @return le client
	 */
	public Client findByClientNumber(final String clientNumber);

}
