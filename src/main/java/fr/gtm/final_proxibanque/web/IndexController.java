package fr.gtm.final_proxibanque.web;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gtm.final_proxibanque.business.ClientService;
import fr.gtm.final_proxibanque.business.ResponseService;
import fr.gtm.final_proxibanque.business.SurveyService;
import fr.gtm.final_proxibanque.domain.Survey;

@Controller
public class IndexController {

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
	public String viewaccueil() {
		return "index";
	}
	
	@PostMapping({ "/index", "/accueil"})
	public String search(@RequestParam("dateOuverture") LocalDate dateO , @RequestParam("dateFermeturePrevisionnelle") LocalDate dateFP) {
		String reponse;
		Survey survey = new Survey();
		survey.setStartDate(dateO);
		survey.setExpectedDate(dateFP);
		this.surveyService.create(survey);
		return reponse;
	}



}
