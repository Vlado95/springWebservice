package fitec.ws;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fitec.dba.metier.Editeur;
import fitec.service.ServiceEditeur;
import fitec.service.ServiceLivre;
import fitec.service.Services;

@RestController
@RequestMapping(value = "/rs")
public class WSEditeur extends Services<Editeur> {

	private ServiceEditeur service;


	public ServiceEditeur getService() {
		return service;
	}

	@Autowired
	public void setService(ServiceEditeur service) {
		this.service = service;
	}
	
   
	@RequestMapping(value = "/editeurs", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllEditeurs() throws InterruptedException {
		List<Editeur> l = service.liste(new Editeur());
		System.out.println("Total éditeur ramené :"+l.size());
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/editeurs/{Str}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getEditeur(@PathVariable("Str") String str) throws InterruptedException {
		List<Editeur> l = service.selectLike(str);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	

}
