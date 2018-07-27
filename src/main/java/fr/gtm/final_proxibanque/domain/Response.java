package fr.gtm.final_proxibanque.domain;

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
public class Response {

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
	 * Le sondage en question-
	 */
	@ManyToOne
	@JoinColumn(name = "id_survey")
	private Survey survey;

	public Response() {

	}

	public Client getClient() {
		return this.client;
	}

	public String getComment() {
		return this.comment;
	}

	public Integer getId() {
		return this.id;
	}

	public Survey getSurvey() {
		return this.survey;
	}

	public boolean isNewClient() {
		return this.newClient;
	}

	public boolean isPositiveResponse() {
		return this.positiveResponse;
	}

	public void setClient(final Client client) {
		this.client = client;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public void setNewClient(final boolean newClient) {
		this.newClient = newClient;
	}

	public void setPositiveResponse(final boolean positiveResponse) {
		this.positiveResponse = positiveResponse;
	}

	public void setSurvey(final Survey survey) {
		this.survey = survey;
	}

}
