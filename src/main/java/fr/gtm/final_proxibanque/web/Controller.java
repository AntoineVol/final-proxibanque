package fr.gtm.final_proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.final_proxibanque.business.ClientService;

@org.springframework.stereotype.Controller

public class Controller {
	
	@Autowired
	private ClientService clientService;
	private ResponseService responseService;
	

}
