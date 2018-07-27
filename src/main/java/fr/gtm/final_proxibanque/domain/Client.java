package fr.gtm.final_proxibanque.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * La classe client designe un client de la banque Proxibanque
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@Entity
public class Client implements Serializable {
	/**
	 * Clé de serialisation
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Le clientNumber designe le numéro d'adhérent unique d'un client
	 */
	@Column(length = 8)
	private String clientNumber;
	/**
	 * L'email designe l'adresse email du client
	 */
	private String email;
	/**
	 * Le firstName désigne le prénom du client
	 */
	private String firstName;
	/**
	 * L'id désigne l'identifiant unique utilisé dans la base de données Il est
	 * généré en automatique par la base de donnée
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * Le lastName désigne le nom du client
	 */
	private String lastName;
	/**
	 * Le tel designe le numéro de téléphone du client
	 *
	 */
	private String tel;

	/**
	 * Getter du clientNumber
	 *
	 * @return clientNumber, le numero d'adhesion du client
	 */
	public String getClientNumber() {
		return this.clientNumber;
	}

	/**
	 * Getter du email
	 *
	 * @return email, l'email du client
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Getter du firstName
	 *
	 * @return firstName, le prenom du client
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Getter de l'id
	 *
	 * @return id, le numero d'identifiant en base de donnée du client
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Getter du lastName
	 *
	 * @return lastName, le nom du client
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Getter du tel
	 *
	 * @return tel, le numero de téléphone du client
	 */
	public String getTel() {
		return this.tel;
	}

	/**
	 * Setter du clientNumber, le numero d'adhesion du client
	 *
	 * @param clientNumber
	 *            Numero d'identifiant à 8 chiffre du client
	 */
	public void setClientNumber(final String clientNumber) {
		this.clientNumber = clientNumber;
	}

	/**
	 * Setter du email, l'email du client
	 *
	 * @param email
	 *            Email du client
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Setter du firstName, le prenom du client
	 *
	 * @param firstName
	 *            Prenom du client
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Setter de l'id, le numero d'identifiant en base de donnée du client
	 *
	 * @param id
	 *            Id du client
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Setter du lastName, le nom du client
	 *
	 * @param lastName
	 *            Nom du client
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Setter du tel, le numero de téléphone du client
	 *
	 * @param tel
	 *            Numero de telephone du client
	 */
	public void setTel(final String tel) {
		this.tel = tel;
	}
}
