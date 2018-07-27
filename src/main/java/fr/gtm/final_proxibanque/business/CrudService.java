package fr.gtm.final_proxibanque.business;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.final_proxibanque.domain.MauvaiseDateException;

/**
 * Le CrudService est un service qu'on met en place pour factoriser le crud pour toutes les entités
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
public abstract class CrudService<ENTITY> {

	@Autowired
	protected JpaRepository<ENTITY, Integer> repo;

	/**
	 * La methode create permet créer en base l'entité
	 *
	 * @return ça retourne l'entité créée
	 */
	public ENTITY create(final ENTITY entity) throws MauvaiseDateException {
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
	 *@return ça retourne la liste des entités
	 */
	public List<ENTITY> getAll() {
		return this.repo.findAll();
	}

	/**
	 * La methode read permet de récupérer un entité en la récupérant grâce à son identifiant
	 *
	 *@return ça retourne l'entité
	 */
	public ENTITY read(final Integer id) {
		ENTITY entity = null;
		final Optional<ENTITY> opt = this.repo.findById(id);
		if (opt.isPresent()) {
			entity = opt.get();
		}
		return entity;
	}

	/**
	 * La methode update permet mettre à jour l'entité
	 *
	 *@return ça retourne l'entité
	 */
	public ENTITY update(final ENTITY entity) {
		return this.repo.save(entity);
	}
}
