package fr.gtm.finalproxibanque.business;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.finalproxibanque.domain.MauvaiseDateException;
import fr.gtm.finalproxibanque.web.ResponseController;

/**
 * Le CrudService est un service qu'on met en place pour factoriser le crud pour
 * toutes les entités
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
public abstract class CrudService<E> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseController.class);
	@Autowired
	protected JpaRepository<E, Integer> repo;

	/**
	 * La methode create permet créer en base l'entité
	 *
	 * @return ça retourne l'entité créée
	 */
	public E create(final E entity) throws MauvaiseDateException {
		CrudService.LOGGER.debug("Passage par le crud service");
		return this.repo.save(entity);
	}

	/**
	 * La methode delete permet supprimer en base l'entité
	 *
	 */
	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	/**
	 * La methode getAll permet de récupérer la liste des entités en base
	 *
	 * @return ça retourne la liste des entités
	 */
	public List<E> getAll() {
		return this.repo.findAll();
	}

	/**
	 * La methode read permet de récupérer un entité en la récupérant grâce à son
	 * identifiant
	 *
	 * @return ça retourne l'entité
	 */
	public E read(final Integer id) {
		E entity = null;
		final Optional<E> opt = this.repo.findById(id);
		if (opt.isPresent()) {
			entity = opt.get();
		}
		return entity;
	}

	/**
	 * La methode update permet mettre à jour l'entité
	 *
	 * @return ça retourne l'entité
	 */
	public E update(final E entity) {
		return this.repo.save(entity);
	}
}
