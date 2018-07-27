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

import fr.gtm.final_proxibanque.business.ClientService;
import fr.gtm.final_proxibanque.business.ResponseService;
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
	private ClientService clientService;

	@Autowired
	private ResponseService responseService;

	@Autowired
	private SurveyService surveyService;


	@GetMapping({ "/index" })
	public String index() {
		return CHEMIN_ACCUEIL;
	}

	@GetMapping({ "/accueil" })
	public ModelAndView viewaccueil() {
		ModelAndView mav = new ModelAndView("index");
		boolean isRunning = this.surveyService.isClosable();
		mav.addObject("surveys", this.surveyService.getAll());
		mav.addObject("isRunning", isRunning);
		return mav;
	}
	
	@GetMapping({ "/details" })
	public ModelAndView details(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("details");
		List<Response> rep = this.surveyService.read(id).getResponses();
		mav.addObject("responses", rep);
		mav.addObject("positif",  this.surveyService.getPositiveCount(rep));
		mav.addObject("negatif",  rep.size() - this.surveyService.getPositiveCount(rep));
		mav.addObject("nc",  this.surveyService.getNewClientCount(rep));
		return mav;

	}
	
	@PostMapping(value = { "/index", "/accueil"} , params = "dateFermeturePrevisionnelle")
	public ModelAndView postaccueil(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOuverture,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFermeturePrevisionnelle, RedirectAttributes redirectA) {
		String message="";
		Survey survey = new Survey();
		survey.setStartDate(dateOuverture);
		survey.setExpectedDate(dateFermeturePrevisionnelle);
		try {
			this.surveyService.create(survey);
		} catch (MauvaiseDateException e) {
			message=e.getMessage();
		}
		ModelAndView mav = new ModelAndView(CHEMIN_ACCUEIL);
		redirectA.addFlashAttribute("message",message);
		return mav;

	}

	@PostMapping(value = { "/index", "/accueil"} , params = "dateFermeture")
	public ModelAndView postacceuilF(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFermeture, RedirectAttributes redirectAttr) {
		String message="";
		try {
			this.surveyService.updateEndDate(dateFermeture);
		} catch (MauvaiseDateException e) {
			message=e.getMessage();
		}
		LOGGER.info(message);
		ModelAndView mav = new ModelAndView(CHEMIN_ACCUEIL);
		redirectAttr.addFlashAttribute("message",message);
		return mav;
	}

}
