package fr.gtm.finalproxibanque.business;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.finalproxibanque.dao.SurveyRepository;
import fr.gtm.finalproxibanque.domain.MauvaiseDateException;
import fr.gtm.finalproxibanque.domain.Response;
import fr.gtm.finalproxibanque.domain.Survey;

/**
 * Le CrudService est le service générique. Il sera utilisé par les services de
 * survey, client et réponses pour les méthodes classiques du CRUD. La création,
 * la remontée d'un élément en fonction de son ID, la remonté de tous les
 * éléments, la modification d'un élément et la supression d'un élément par son
 * id.
 *
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
					"Attention: la date de fermeture prévisionnelle doit être postérieure à la date d'ouverture du sondage.");
		}
		this.repo.save(survey);
		SurveyService.LOGGER.debug("Sondage persisté en base");
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
	 * La methode isClosable vérifie si il existe un sondage actif
	 *
	 * @return false si il n'y a pas de sondage actif, true si il existe un sondage
	 *         actif
	 */
	public boolean isClosable() {
		boolean isRunning = false;
		final LocalDate today = LocalDate.now();
		final List<Survey> surveys = this.repo.findAll();
		for (final Survey survey : surveys) {
			if (survey.getEndDate() == null || survey.getEndDate().isAfter(today)) {
				isRunning = true;
			}
		}
		return isRunning;
	}

	/**
	 * La methode updateEndDate met à jour la date de fin d'un sondage et la
	 * persiste. Cette méthode n'est valable que pour un sondage actif. Si la date
	 * de fermeture est antérieur à la date d'ouverture, une erreur est renvoyé pour
	 * un affichage dans la JSP d'un message d'erreur.
	 *
	 * @param date
	 *            Date de fin définie pour le sondage
	 * @throws MauvaiseDateException
	 *             Erreur relever si la date de fin rensigné est antérieur à la date
	 *             de début de sondage
	 */

	public void updateEndDate(final LocalDate date) throws MauvaiseDateException {
		final List<Survey> surveys = this.repo.findAll();
		final LocalDate today = LocalDate.now();
		for (final Survey survey : surveys) {
			if (survey.getEndDate() == null || survey.getEndDate().isAfter(today)) {
				if (date.isBefore(survey.getStartDate())) {
					throw new MauvaiseDateException(
							"Attention: la date de fermeture doit être postérieure à la date d'ouverture du sondage.");
				}
				survey.setEndDate(date);
				this.update(survey);
			}
		}
	}

}
