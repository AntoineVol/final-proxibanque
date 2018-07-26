package fr.gtm.final_proxibanque.web;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.ParserSharedInputState;
import fr.gtm.final_proxibanque.business.ClientService;
import fr.gtm.final_proxibanque.business.ResponseService;
import fr.gtm.final_proxibanque.business.SurveyService;
import fr.gtm.final_proxibanque.domain.Response;
import fr.gtm.final_proxibanque.domain.Survey;

@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(IndexController.class);
	
	@Autowired
	private ClientService clientService;

	@Autowired
	private ResponseService responseService;

	@Autowired
	private SurveyService surveyService;

	private final static String CHEMIN_ACCUEIL = "redirect:/accueil.html";

	@GetMapping({ "/index" })
	public String index() {
		return CHEMIN_ACCUEIL;
	}

	@GetMapping({ "/accueil" })
	public ModelAndView viewaccueil() {
		ModelAndView mav = new ModelAndView("index");
		int isRunning = this.surveyService.isClosable();
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
	public ModelAndView postaccueil(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOuverture,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFermeturePrevisionnelle) {
		
		Survey survey = new Survey();
		survey.setStartDate(dateOuverture);
		survey.setExpectedDate(dateFermeturePrevisionnelle);
		this.surveyService.create(survey);
		ModelAndView mav = new ModelAndView(CHEMIN_ACCUEIL);
		return mav;
		
	}
	
	@PostMapping(value = { "/index", "/accueil"} , params = "dateFermeture")
	public ModelAndView postacceuilF(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFermeture) {
		LOGGER.info(dateFermeture.toString());
		this.surveyService.updateEndDate(dateFermeture);
		LOGGER.info("je suis sorti");
		ModelAndView mav = new ModelAndView(CHEMIN_ACCUEIL);	
		return mav;
		
	}



}
