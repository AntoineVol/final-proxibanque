package fr.gtm.final_proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.gtm.final_proxibanque.business.ClientService;
import fr.gtm.final_proxibanque.business.ResponseService;


@Controller
public class IndexController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ResponseService responseService;
	

}
