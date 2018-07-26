package fr.gtm.final_proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.gtm.final_proxibanque.business.ClientService;
import fr.gtm.final_proxibanque.business.ResponseService;
import fr.gtm.final_proxibanque.business.SurveyService;


@Controller
public class IndexController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private SurveyService surveyService;
	
	
	private final static String CHEMIN_ACCUEIL = "accueil";
	
	
	
	
	@GetMapping({ "/index", "/accueil" })
	public String accueil() {

		return CHEMIN_ACCUEIL;
	}

}
