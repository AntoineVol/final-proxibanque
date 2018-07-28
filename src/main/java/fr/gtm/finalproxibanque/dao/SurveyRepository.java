package fr.gtm.finalproxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.finalproxibanque.domain.Survey;

/**
 * L'interface SurveyRepository permet de lier l'entité Client à un JPA
 * repository
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {

}
