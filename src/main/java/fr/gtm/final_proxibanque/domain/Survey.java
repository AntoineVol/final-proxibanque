package fr.gtm.final_proxibanque.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * @author Kamir, Antoine, Steven
 *
 */
public class Survey implements Serializable {
	
	// Attributes of the Survey class 

	private static final long serialVersionUID = 1L;
	private Integer id;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate expectedDate;
	private List<Reponse> reponses;
	
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
	 * @return the reponses
	 */
	public List<Reponse> getReponses() {
		return reponses;
	}
	/**
	 * @param reponses the reponses to set
	 */
	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}	

}
