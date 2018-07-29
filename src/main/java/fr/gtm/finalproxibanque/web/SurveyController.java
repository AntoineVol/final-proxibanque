package fr.gtm.finalproxibanque.web;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.finalproxibanque.business.SurveyService;
import fr.gtm.finalproxibanque.domain.Survey;

/**
 * La class SurveyController est un web service qui permet de dispatcher les
 * requetes HTTP concernant l'entité Survey.
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@RestController
@RequestMapping("/survey")
public class SurveyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);

	@Autowired
	private SurveyService surveyService;

	/**
	 * La methode getSurveyDate est un WebService permettant de retourner le sondage
	 * actif. Un sondage est actif si sa date de début est antérieur ou égale à la
	 * date du jour et si date de fin est postérieure à la date du jour ou non
	 * définie. La date previsonnelle n'entre pas en jeu, elle n'est presente qu'à
	 * titre indicatif
	 *
	 * @return Le seule sondage actif
	 */
	@RequestMapping({ "", "/" })
	public Survey getSurveyDate() {
		final LocalDate today = LocalDate.now();
		final List<Survey> survies = this.surveyService.getAll();

		for (final Survey s : survies) {
			if ((s.getStartDate().isBefore(today) || s.getStartDate().isEqual(today))
					&& (s.getEndDate() == null || s.getEndDate().isEqual(today) || s.getEndDate().isAfter(today))) {
				SurveyController.LOGGER
						.info("je retourne un sondage -- méthode getSurveyDate -- class SurveyController");
				return s;
			}
		}

		SurveyController.LOGGER.info(
				"je retourne null car je n'ai pas trouvé de sondage -- méthode getSurveyDate -- class SurveyController");
		return null;

	}

	/**
	 * La methode getSurveyId est un WebService permettant de retourner un sondage à
	 * partir de son id
	 *
	 * @param id
	 *            du sondage recherché
	 * @return Le sondage persisté en base
	 */
	@RequestMapping("/{id}")
	public Survey getSurveyId(@PathVariable final Integer id) {
		SurveyController.LOGGER
				.info("je retourne un sondage grâce à son id -- méthode getSurveyId -- class SurveyController");
		return this.surveyService.read(id);
	}

}
