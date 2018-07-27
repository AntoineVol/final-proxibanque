package fr.gtm.final_proxibanque.business;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.gtm.final_proxibanque.dao.SurveyRepository;
import fr.gtm.final_proxibanque.domain.Response;
import fr.gtm.final_proxibanque.domain.Survey;

/**
 * Le SurveyService est le service apparenté l'entité Surveys
 *
 * @author Kamir Elsisi & Steven Roman & Antoine Volatron
 *
 */
@Service
public class SurveyService extends CrudService<Survey> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyService.class);

	/**
	 * La methode getNewClientCount permet de connaitre la part de client s'étant
	 * enregistrer lors de la réponse au sondage Les autres réponses viennent de
	 * client déjà inscrits chez proxibanque
	 *
	 * @param responses,
	 *            la liste des réponses dans laquelle nous voulons connaitre la part
	 *            de nouveau client
	 * @return Le nombre de nouveaux clients
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
	 * La methode getPositiveCount permet de connaite la part de réponse positive
	 * d'un sondage en analysant la liste des réponse.
	 *
	 * @param responses,
	 *            la liste des réponses dans laquelle nous voulons connaitre la part
	 *            de reponses positives
	 * @return Le nombre de réponse positive du sondage
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

	/**
	 * La methode SurveyRepository permet de recupérer le repository de la classe en
	 * forcant sont typage en "Repository"
	 *
	 * @return Le repository du Survey
	 */
	public SurveyRepository getRepo() {
		return (SurveyRepository) this.repo;
	}

	/**
	 * La methode isClosable permet de savoir si l'on peut definir une date de fin à
	 * un sondage. Pour cela il faut que le sondage soit actif.
	 *
	 * @return true si une date de fermeture peut-être fixée, false si le sondage
	 *         n'est plus actif
	 */
	public int isClosable() {
		int isRunning = 0;
		final List<Survey> surveys = this.repo.findAll();
		for (final Survey survey : surveys) {
			if (survey.getEndDate() == null) {
				isRunning = 1;
			}
		}
		return isRunning;
	}

	/**
	 * La methode updateEndDate met à jour la date de fin d'un sondage et la
	 * persiste
	 * 
	 * @param date
	 *            Date de fin définie pour le sondage
	 */
	public void updateEndDate(final LocalDate date) {
		final List<Survey> surveys = this.repo.findAll();
		for (final Survey survey : surveys) {
			if (survey.getEndDate() == null) {
				survey.setEndDate(date);
				this.update(survey);
				SurveyService.LOGGER.info("j'ai mis à jour" + this.isClosable());
			}
		}
	}

}
