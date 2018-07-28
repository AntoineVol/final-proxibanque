package fr.gtm.finalproxibanque.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.finalproxibanque.domain.Response;

/**
 * L'interface ResponseRepository permet de lier l'entité Client à un JPA
 * repository
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@Repository
@Transactional
public interface ResponseRepository extends JpaRepository<Response, Integer> {

}
