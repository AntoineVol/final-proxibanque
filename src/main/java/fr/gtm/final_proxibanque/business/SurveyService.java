package fr.gtm.final_proxibanque.business;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.final_proxibanque.dao.SurveyRepository;
import fr.gtm.final_proxibanque.domain.MauvaiseDateException;
import fr.gtm.final_proxibanque.domain.Response;
import fr.gtm.final_proxibanque.domain.Survey;

/**
 * Le SurveyService est le service apparenté l'entité Surveys
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */

@Service
public class SurveyService extends CrudService<Survey> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyService.class);

	@Autowired
	private ResponseService responseService;

	@Override
	public Survey create(final Survey survey) throws MauvaiseDateException {
		if (survey.getExpectedDate().isBefore(survey.getStartDate())) {
			throw new MauvaiseDateException(
					"La date de fermeture prévisionnelle doit être postérieure à la date d'ouverture du sondage");
		}
		this.repo.save(survey);
		return survey;
	}

	/**
	 * La methode getNewClientCount retourne le nombre de d'inscription de nouveaux
	 * clients générées par un sondage
	 *
	 * @param responses
	 *            Liste des réponses d'un sondage
	 * @return Le nombre de nouvelles inscription
	 */
	public Integer getNewClientCount(final List<Response> responses) {
		Integer count = 0;
		for (final Response response : responses) {
			if (response.isNewClient()) {
				count++;
			}
		}
		return count;
	}

	/**
	 * La methode getPositiveCount retourne le nombre de réponse positive d'un
	 * sondage
	 *
	 * @param responses
	 *            La liste des réponses d'un sondage
	 * @return Le nombre de réponse positive
	 */
	public Integer getPositiveCount(final List<Response> responses) {
		Integer count = 0;
		for (final Response response : responses) {
			if (response.isPositiveResponse()) {
				count++;
			}
		}
		return count;
	}

	public SurveyRepository getRepo() {
		return (SurveyRepository) this.repo;
	}
	
/**
 * La methode updateEndDate met à jour la date de fin d'un sondage et la
 * persiste
 * 
 * @param date
 *            Date de fin définie pour le sondage
 * @throws MauvaiseDateException
 *             Erreur relever si la date de fin rensigné est antérieur à la date
 *             de début de sondage
 */
	
	public void updateEndDate(LocalDate date) throws MauvaiseDateException {
		List<Survey> surveys = this.repo.findAll();
		LocalDate today = LocalDate.now();
		for (Survey survey : surveys) {
			if(survey.getEndDate()==null||survey.getEndDate().isAfter(today)) {
				if(date.isBefore(survey.getStartDate())) {
					throw new MauvaiseDateException("La date de fermeture doit être postérieure à la date d'ouverture du sondage");
				}
				survey.setEndDate(date);
				this.update(survey);
			}
		}
	}

	/**
	 * La methode isClosable vérifie si il existe un sondage actif
	 *
	 * @return false si il n'y a pas de sondage actif, true si il existe un sondage
	 *         actif
	 */
	public boolean isClosable() {
		boolean isRunning = false;
		LocalDate today = LocalDate.now();
		List<Survey> surveys = this.repo.findAll();
		for (Survey survey : surveys) {
			if(survey.getEndDate()==null||survey.getEndDate().isAfter(today)) {
				isRunning = true;
			}
		}
		return isRunning;
	}

}
