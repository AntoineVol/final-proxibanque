package fr.gtm.final_proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.gtm.final_proxibanque.business.SurveyService;
import fr.gtm.final_proxibanque.domain.Survey;

@RestController("/api/survey")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	
	@RequestMapping("/{id}")
	public Survey getSurvey(@PathVariable final Integer id){
		return surveyService.read(id);
	}
	

}
