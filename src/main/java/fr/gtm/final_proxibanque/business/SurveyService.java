package fr.gtm.final_proxibanque.business;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.gtm.final_proxibanque.dao.SurveyRepository;
import fr.gtm.final_proxibanque.domain.Response;
import fr.gtm.final_proxibanque.domain.Survey;
import fr.gtm.final_proxibanque.web.IndexController;

@Service
public class SurveyService extends CrudService<Survey> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SurveyService.class);
	
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
	
	public void updateEndDate(LocalDate date) {
		List<Survey> surveys = this.repo.findAll();
		for (Survey survey : surveys) {
			if(survey.getEndDate()==null) {
				survey.setEndDate(date);
				this.update(survey);
				LOGGER.info("j'ai mis à jour" +this.isClosable());
			}
		}
	}
	
	public int isClosable() {
		int isRunning = 0;
		List<Survey> surveys = this.repo.findAll();
		for (Survey survey : surveys) {
			if(survey.getEndDate()==null) {
				isRunning = 1;
			}
		}		
		return isRunning;
	}
	
	
}

