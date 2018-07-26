package fr.gtm.final_proxibanque.business;

import org.springframework.stereotype.Service;

import fr.gtm.final_proxibanque.dao.SurveyRepository;
import fr.gtm.final_proxibanque.domain.Survey;

@Service
public class SurveyService extends CrudService<Survey> {

	public SurveyRepository getRepo() {
		return (SurveyRepository) this.repo;
	}
}
