package fr.gtm.final_proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.final_proxibanque.domain.Client;

/**
 * L'interface ClientRepository permet de lier l'entité Client à un JPA
 * repository
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	Client findByClientNumber(String clientNumber);

}
