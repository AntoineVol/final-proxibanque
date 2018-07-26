package fr.gtm.final_proxibanque.web;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.final_proxibanque.business.ClientService;
import fr.gtm.final_proxibanque.business.ResponseService;
import fr.gtm.final_proxibanque.business.SurveyService;
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
		mav.addObject("surveys", this.surveyService.getAll());
		return mav;
	}
	
	@GetMapping({ "/details" })
	public ModelAndView details(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("details");
		mav.addObject("responses", this.surveyService.read(id).getResponses());
		return mav;
	}
	
	
	
	@PostMapping({ "/index", "/accueil"})
	public ModelAndView search(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOuverture,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFermeturePrevisionnelle) {
		
		Survey survey = new Survey();
		survey.setStartDate(dateOuverture);
		survey.setExpectedDate(dateFermeturePrevisionnelle);
		this.surveyService.create(survey);
		ModelAndView mav = new ModelAndView("redirect:/index.html");
		return mav;
		
	}



}
