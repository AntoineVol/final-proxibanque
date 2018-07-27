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
 * @author Kamir, Antoine, Steven
 *
 */

@Entity
public class Survey implements Serializable {

	// Attributes of the Survey class

	private static final long serialVersionUID = 1L;
	@Column
	private LocalDate endDate;

	/**
	 *
	 */
	@Column
	private LocalDate expectedDate;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "survey", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Response> responses = new ArrayList<>();

	@Column
	private LocalDate startDate;

	// Getters & Setters

	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return this.endDate;
	}

	/**
	 * @return the expectedDate
	 */
	public LocalDate getExpectedDate() {
		return this.expectedDate;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the responses
	 */
	public List<Response> getResponses() {
		return this.responses;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return this.startDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(final LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param expectedDate
	 *            the expectedDate to set
	 */
	public void setExpectedDate(final LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param responses
	 *            the responses to set
	 */
	public void setResponses(final List<Response> responses) {
		this.responses = responses;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(final LocalDate startDate) {
		this.startDate = startDate;
	}

}
