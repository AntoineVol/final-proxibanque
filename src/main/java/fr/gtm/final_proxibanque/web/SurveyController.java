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

@RestController
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	
	@RequestMapping("/{id}")
	public Survey getSurveyId(@PathVariable final Integer id){
		return surveyService.read(id);
	}
	
	@RequestMapping({"","/"})
	public Survey getSurveyDate(){
		LocalDate today = LocalDate.now();
		List<Survey> survies = new ArrayList<Survey>();
		survies = this.surveyService.getAll();
		
		for (Survey s : survies){
			if ((s.getStartDate().isBefore(today) || s.getStartDate().isEqual(today)) && ((s.getEndDate() == null) || s.getEndDate().isEqual(today)||
					s.getEndDate().isAfter(today))){
				
				return s;
			}
		}
		
		return null;

	}
	

}
