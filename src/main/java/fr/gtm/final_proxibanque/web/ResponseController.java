package fr.gtm.final_proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fr.gtm.final_proxibanque.business.ResponseService;
import fr.gtm.final_proxibanque.domain.Response;

@RestController("/api/response")
public class ResponseController {
	
	@Autowired
	private ResponseService responseService;
	
	
	@PostMapping
	public Response addResponse(@RequestBody final Response response) {
		return this.responseService.create(response);
	}

}
