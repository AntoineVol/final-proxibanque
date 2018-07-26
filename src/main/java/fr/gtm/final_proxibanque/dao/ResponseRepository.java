package fr.gtm.final_proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.fabric.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer>{

}
