package fr.gtm.final_proxibanque.web;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.gtm.final_proxibanque.business.SurveyService;
import fr.gtm.final_proxibanque.domain.MauvaiseDateException;
import fr.gtm.final_proxibanque.domain.Response;
import fr.gtm.final_proxibanque.domain.Survey;

/**
 * La class IndexController permet de dispatcher les requetes HTTP concernant le
 * backend
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@Controller
public class IndexController {

	private final static String CHEMIN_ACCUEIL = "redirect:/accueil.html";

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private SurveyService surveyService;

	/**
	 * La méthode details permet d'accèder à la JSP détaillant les réponses d'un
	 * sondage. Cette JSP contient un tableau contenant tous les commentaires des
	 * réponses négatives, un indicateur de réponse positive et négative, ainsi que
	 * le nombre de nouveau client s'étant inscrit pour répondre positivement au
	 * questionnaire
	 *
	 * @param id
	 *            Identifiant du sondage
	 * @return La JSP de détail du sondage
	 */
	@GetMapping({ "/details" })
	public ModelAndView details(@RequestParam("id") final Integer id) {
		final ModelAndView mav = new ModelAndView("details");
		final List<Response> rep = this.surveyService.read(id).getResponses();
		LOGGER.info("j'ai récupéré la liste des réponses d'un sondage grâce à son id -- méthode détails -- class IndexController");
		mav.addObject("responses", rep);
		mav.addObject("positif", this.surveyService.getPositiveCount(rep));
		mav.addObject("negatif", rep.size() - this.surveyService.getPositiveCount(rep));
		mav.addObject("nc", this.surveyService.getNewClientCount(rep));
		return mav;

	}

	/**
	 * La méthode index lance une redirection vers l'url d'accueil
	 *
	 * @return L'url de la page d'accueil
	 */
	@GetMapping({ "/index" })
	public String index() {
		return IndexController.CHEMIN_ACCUEIL;
	}

	/**
	 * La méthode postacceuilF est la méthode de validation du formulaire qui
	 * paramètre la date de cloture d'un sondage. Cette methode vérifie que la date
	 * renseignée est supérieure à la date de début du sondage en cours. Si la
	 * condition est remplie, la date de cloture est persisté en base pour le
	 * sondage en question
	 *
	 * @param dateFermeture
	 *            Date à laquelle le formulaire se cloturera
	 * @param redirectAttr
	 *            Message d'erreur transmis par l'URL en cas de remonté d'erreur
	 *            (date de cloture anterieur à la date de début)
	 * @return La JSP d'acceuil, listant les sondages
	 */
	@PostMapping(value = { "/index", "/accueil" }, params = "dateFermeture")
	public ModelAndView postacceuilF(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate dateFermeture,
			final RedirectAttributes redirectAttr) {
		String message = "";
		try {
			this.surveyService.updateEndDate(dateFermeture);
			LOGGER.info("j'ai mis à jour la date de fermeture du sondage -- méthode postaccueilF -- class IndexController");
		} catch (final MauvaiseDateException e) {
			message = e.getMessage();
			IndexController.LOGGER.info(message);
		}
		final ModelAndView mav = new ModelAndView(IndexController.CHEMIN_ACCUEIL);
		redirectAttr.addFlashAttribute("message", message);
		return mav;
	}

	/**
	 * La méthode postaccueil est la méthode de validation du formulaire qui crée un
	 * nouveau sondage.Cette methode vérifie que la date de fermeture previsionnelle
	 * renseignée est supérieure à la date de début. Si la condition est remplie, le
	 * sondage est persistée en base.
	 *
	 * @param dateOuverture
	 *            Date à laquelle le sondage sera accessible aux clients
	 * @param dateFermeturePrevisionnelle
	 *            Date de fin prévue. Cette information est purement informative
	 * @param redirectA
	 *            Message d'erreur transmis par l'URL en cas de remonté d'erreur
	 *            (date de cloture anterieur à la date de début)
	 * @return La JSP d'acceuil, listant les sondages
	 */
	@PostMapping(value = { "/index", "/accueil" }, params = "dateFermeturePrevisionnelle")
	public ModelAndView postaccueil(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate dateOuverture,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate dateFermeturePrevisionnelle,
			final RedirectAttributes redirectA) {
		String message = "";
		final Survey survey = new Survey();
		LOGGER.info("je créé un sondage en locale -- méthode postaccueil -- class IndexController");
		survey.setStartDate(dateOuverture);
		LOGGER.info("je définis sa date d'ouverture -- méthode postaccueil -- class IndexController");
		survey.setExpectedDate(dateFermeturePrevisionnelle);
		LOGGER.info("je définis sa date de fermeture previsionnelle -- méthode postaccueil -- class IndexController");
		try {
			this.surveyService.create(survey);
			LOGGER.info("je créé le sondage -- méthode postaccueil -- class IndexController");
		} catch (final MauvaiseDateException e) {
			message = e.getMessage();
			IndexController.LOGGER.info(message);
		}
		final ModelAndView mav = new ModelAndView(IndexController.CHEMIN_ACCUEIL);
		redirectA.addFlashAttribute("message", message);
		return mav;

	}

	/**
	 * La méthode viewaccueil affiche la JSP listant les sondages. On y trouve
	 * également un formulaire de création de sondage et un formulaire pour
	 * paramétrer la date de cloture d'un sondage
	 * 
	 * @return La JSP d'acceuil, listant les sondages
	 */
	@GetMapping({ "/accueil" })
	public ModelAndView viewaccueil() {
		final ModelAndView mav = new ModelAndView("index");
		LOGGER.info("je me renseigne pour savoir s'il y a un sondage en cours -- méthode viewaccueil -- class IndexController");
		final boolean isRunning = this.surveyService.isClosable();
		mav.addObject("surveys", this.surveyService.getAll());
		mav.addObject("isRunning", isRunning);
		return mav;
	}

}
