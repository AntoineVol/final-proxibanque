package fr.gtm.final_proxibanque.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CrudService<ENTITY> {

	@Autowired
	protected JpaRepository<ENTITY, Integer> repo;

	public ENTITY create(final ENTITY entity) {
		return this.repo.save(entity);
	}

	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	public List<ENTITY> getAll() {
		return this.repo.findAll();
	}

	public ENTITY read(final Integer id) {
		ENTITY entity = null;
		final Optional<ENTITY> opt = this.repo.findById(id);
		if (opt.isPresent()) {
			entity = opt.get();
		}
		return entity;
	}

	public ENTITY update(final ENTITY entity) {
		return this.repo.save(entity);
	}
}
