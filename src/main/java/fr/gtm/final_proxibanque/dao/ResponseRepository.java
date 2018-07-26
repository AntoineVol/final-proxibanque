package fr.gtm.final_proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.final_proxibanque.domain.Survey;

public interface ResponseRepository extends JpaRepository<Survey, Integer>{

}
