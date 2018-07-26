package fr.gtm.final_proxibanque.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Kamir, Antoine, Steven
 * 
 * La classe Response représente la réponse du client au sondage
 *
 */
@Entity
public class Response {
	
	/**
	 * Identifiant d'une instance de Response au niveau de la base de données
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Un commentaire laissé par un client pour un sondage
	 */
	private String comment;
	
	/**
	 * avis favorable ou non du client au sondage
	 */
	private boolean positiveResponse;
	
	/**
	 * Le client qui a donné un avis au sondage est-il un nouveau?
	 */
	private boolean newClient;
	
	/**
	 * Le client qui a répondu au sondage positivement
	 */
	@ManyToOne
	@JoinColumn(name="id_client", referencedColumnName="id")
	private Client client;
	

	/**
	 * Le sondage en question-
	 */
	@ManyToOne
	@JoinColumn(name="id_survey")
	private Survey survey;
	
	
	public Response() {
		
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
