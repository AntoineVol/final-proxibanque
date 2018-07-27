package fr.gtm.final_proxibanque.domain;
/**
 * Exception qui nous permet de remarque quand on a voulu manipuler la carte blue
 * dans un compte epargne, qui donc n'est pas sensé avoir de carte
 * @author Steven, Kamir et Antoine
 *
 */
public class MauvaiseDateException extends Exception {
	/**
	 *
	 * cnst necesaire pour que la Classe soit Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	public MauvaiseDateException(String message) {

		super(message);
		
	}
}

