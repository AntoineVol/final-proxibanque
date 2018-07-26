package fr.gtm.final_proxibanque.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	private String clientNumber;
	private String email;
	private String firstName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String lastName;
	private String tel;

	public String getClientNumber() {
		return this.clientNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public Integer getId() {
		return this.id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getTel() {
		return this.tel;
	}

	public void setClientNumber(final String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public void setTel(final String tel) {
		this.tel = tel;
	}
}
