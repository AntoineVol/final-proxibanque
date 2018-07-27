package fr.gtm.final_proxibanque.web;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.final_proxibanque.business.SurveyService;
import fr.gtm.final_proxibanque.domain.Survey;

/**
 * La class ResponseController est un web service qui permet de dispatcher les
 * requetes HTTP concernant l'entité Response
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@RestController
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);

	/**
	 * La methode getSurveyDate est un WebService permettant de retourner un le
	 * sondage actif
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
				LOGGER.info("je retourne un sondage -- méthode getSurveyDate -- class SurveyController");
				return s;
			}
		}

		LOGGER.info("je retourne null car je n'ai pas trouvé de sondage -- méthode getSurveyDate -- class SurveyController");
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
		LOGGER.info("je retourne un sondage grâce à son id -- méthode getSurveyId -- class SurveyController");
		return this.surveyService.read(id);
	}

}
