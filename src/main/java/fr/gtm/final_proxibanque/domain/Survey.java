package fr.gtm.final_proxibanque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Kamir, Antoine, Steven
 *
 */
@Entity
public class Survey implements Serializable {
	
	// Attributes of the Survey class 

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate expectedDate;
	@OneToMany(mappedBy="survey")
	private List<Response> responses;
	
	// Getters & Setters
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the expectedDate
	 */
	public LocalDate getExpectedDate() {
		return expectedDate;
	}
	/**
	 * @param expectedDate the expectedDate to set
	 */
	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}
	/**
	 * @return the responses
	 */
	public List<Response> getResponses() {
		return responses;
	}
	/**
	 * @param responses the responses to set
	 */
	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}	

}
