package fr.gtm.final_proxibanque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */

@Entity
public class Survey implements Serializable {

	// Attributes of the Survey class
	/**
	 * Clé de serialisation
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * l'endDate c'est la date de fermeture du sondage
	 */
	private LocalDate endDate;

	/**
	 * l'expectedDate c'est la date de fermeture prévisionnelle du sondage
	 */
	private LocalDate expectedDate;

	/**
	 * L'id désigne l'identifiant unique utilisé dans la base de données Il est
	 * généré en automatique par la base de donnée
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * responses est la liste des reponses à ce sondage. Une réponse
	 * a plusieurs attributs: id, comment, client, newClient, positiveResponse et le survey
	 */
	@OneToMany(mappedBy = "survey", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Response> responses = new ArrayList<>();
	
	/**
	 * l'startDate c'est la date d'ouverture du sondage
	 */
	private LocalDate startDate;

	// Getters & Setters

	/**
	 * Getter de l'endDate
	 * @return the endDate, la date de fermeture du sondage
	 */
	public LocalDate getEndDate() {
		return this.endDate;
	}

	/**
	 * Getter de l'expectedDate
	 * @return the expectedDate, la date de fermeture prévisionnelle du sondage
	 */
	public LocalDate getExpectedDate() {
		return this.expectedDate;
	}

	/**
	 * Getter de l'id
	 * @return the id, l'identifiant unique utilisé dans la base de données
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Getter de responses
	 * @return the responses, la liste des responses du sondage
	 */
	public List<Response> getResponses() {
		return this.responses;
	}

	/**
	 * Getter de startDate
	 * @return the startDate, la date d'ouverture du sondage
	 */
	public LocalDate getStartDate() {
		return this.startDate;
	}

	/**
	 * Setter du l'endDate, date de fermeture du sondage
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(final LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Setter du l'expectedDate, date de fermeture prévisionnelle du sondage
	 * @param expectedDate
	 *            the expectedDate to set
	 */
	public void setExpectedDate(final LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}

	/**
	 * Setter du l'id, identifiant unique du sondage
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Setter de responses, liste des réponses à ce sondage
	 * @param responses
	 *            the responses to set
	 */
	public void setResponses(final List<Response> responses) {
		this.responses = responses;
	}

	/**
	 * Setter du l'startDate, date d'ouverture du sondage
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(final LocalDate startDate) {
		this.startDate = startDate;
	}

}
