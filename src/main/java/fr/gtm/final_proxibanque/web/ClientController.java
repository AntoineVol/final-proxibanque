package fr.gtm.final_proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.gtm.final_proxibanque.business.ClientService;
import fr.gtm.final_proxibanque.domain.Client;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/{id}")
	public Client getClient(@PathVariable final Integer id){
		return clientService.read(id);
	}
	
	@PostMapping({"","/"})
	public Client addClient(@RequestBody final Client client) {
		return this.clientService.create(client);
	}

}
