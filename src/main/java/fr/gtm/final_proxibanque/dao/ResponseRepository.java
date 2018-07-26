package fr.gtm.final_proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.final_proxibanque.domain.Response;


@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer>{

}
