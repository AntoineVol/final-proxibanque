package fr.gtm.final_proxibanque.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 *         La classe Response représente la réponse du client au sondage
 *
 */
@Entity
public class Response implements Serializable {

	/**
	 * Clé de serialisation
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Le client qui a répondu au sondage positivement
	 */
	@ManyToOne
	@JoinColumn(name = "id_client", referencedColumnName = "id")
	private Client client;

	/**
	 * Un commentaire laissé par un client pour un sondage
	 */
	private String comment;

	/**
	 * Identifiant d'une instance de Response au niveau de la base de données
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Le client qui a donné un avis au sondage est-il un nouveau?
	 */
	private boolean newClient;

	/**
	 * avis favorable ou non du client au sondage
	 */
	private boolean positiveResponse;

	/**
	 * Le sondage en question
	 */
	@ManyToOne
	@JoinColumn(name = "id_survey")
	private Survey survey;
	
	

	/**Getter du Client
	 * @return the client, retourne le client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Getter du comment
	 * @return the comment, le commentaire
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Getter de l'id
	 * @return the id, identifiant unique de la réponse
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter du newClient
	 * @return the newClient, qui informe si le client est nouveau ou pas
	 */
	public boolean isNewClient() {
		return newClient;
	}

	/**
	 * @param newClient the newClient to set
	 */
	public void setNewClient(boolean newClient) {
		this.newClient = newClient;
	}

	/**
	 * Getter du positiveResponse
	 * @return the positiveResponse, qui informe si la réponse est positive
	 */
	public boolean isPositiveResponse() {
		return positiveResponse;
	}

	/**
	 * @param positiveResponse the positiveResponse to set
	 */
	public void setPositiveResponse(boolean positiveResponse) {
		this.positiveResponse = positiveResponse;
	}

	/**
	 * Getter du survey
	 * @return the survey, qui est le sondage
	 */
	public Survey getSurvey() {
		return survey;
	}

	/**
	 * @param survey the survey to set
	 */
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	

}
