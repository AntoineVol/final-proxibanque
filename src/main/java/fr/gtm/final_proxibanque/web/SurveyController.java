package fr.gtm.final_proxibanque.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
 * @author Kamir Elsisi & Steven Roman & Antoine Volatron
 *
 */
@RestController
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	/**
	 * La methode getSurveyDate est un WebService permettant de retourner un le
	 * sondage actif
	 *
	 * @return Le seule sondage actif
	 */
	@RequestMapping({ "", "/" })
	public Survey getSurveyDate() {
		final LocalDate today = LocalDate.now();
		List<Survey> survies = new ArrayList<>();
		survies = this.surveyService.getAll();

		for (final Survey s : survies) {
			if ((s.getStartDate().isBefore(today) || s.getStartDate().isEqual(today))
					&& (s.getEndDate() == null || s.getEndDate().isEqual(today) || s.getEndDate().isAfter(today))) {

				return s;
			}
		}

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
		return this.surveyService.read(id);
	}

}
