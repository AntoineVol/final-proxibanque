package fr.gtm.final_proxibanque.business;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.final_proxibanque.dao.SurveyRepository;
import fr.gtm.final_proxibanque.domain.MauvaiseDateException;
import fr.gtm.final_proxibanque.domain.Response;
import fr.gtm.final_proxibanque.domain.Survey;

@Service
public class SurveyService extends CrudService<Survey> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SurveyService.class);
	
	@Autowired
	private ResponseService responseService;
	
	public SurveyRepository getRepo() {
		return (SurveyRepository) this.repo;
	}
	
	public Integer getPositiveCount(List<Response> responses) {
		Integer count = 0;
		for (Response response : responses) {
			if(response.isPositiveResponse()) {
				count++;
			}
		}		
		return count;
	}
	
	public Integer getNewClientCount(List<Response> responses) {
		Integer count = 0;
		for (Response response : responses) {
			if(response.isNewClient()) {
				count++;
			}
		}		
		return count;
	}
	
	
	public void updateEndDate(LocalDate date) throws MauvaiseDateException {
		List<Survey> surveys = this.repo.findAll();
		for (Survey survey : surveys) {
			if(survey.getEndDate()==null) {
				if(date.isBefore(survey.getStartDate())) {
					throw new MauvaiseDateException("La date de fermeture doit être postérieure à la date d'ouverture du sondage");
				}
				survey.setEndDate(date);
				this.update(survey);
			}
		}
	}
	
	public boolean isClosable() {
		boolean isRunning = false;
		List<Survey> surveys = this.repo.findAll();
		for (Survey survey : surveys) {
			if(survey.getEndDate()==null) {
				isRunning = true;
			}
		}		
		return isRunning;
	}
	
	public Survey create(Survey survey) throws MauvaiseDateException {
		if(survey.getExpectedDate().isBefore(survey.getStartDate())) {
			throw new MauvaiseDateException("La date de fermeture prévisionnelle doit être postérieure à la date d'ouverture du sondage");
		}
		this.repo.save(survey);
		return survey;
	}
	
	
}

