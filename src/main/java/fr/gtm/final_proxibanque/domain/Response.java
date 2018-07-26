package fr.gtm.final_proxibanque.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String comment;
	private boolean positiveResponse;
	private boolean newClient;
	
	
	private Client client;
	
	private Survey survey;
	
	
	public Response() {
	}
	
	public Response(String comment, boolean positiveResponse, boolean newClient){
		this.comment = comment;
		this.positiveResponse= positiveResponse;
		this.newClient = newClient;
		
	}
	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isPositiveResponse() {
		return positiveResponse;
	}

	public void setPositiveResponse(boolean positiveResponse) {
		this.positiveResponse = positiveResponse;
	}

	public boolean isNewClient() {
		return newClient;
	}

	public void setNewClient(boolean newClient) {
		this.newClient = newClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	
	
	
	

}
