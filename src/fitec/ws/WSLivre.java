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

import fitec.dba.metier.Livre;
import fitec.service.ServiceLivre;
import fitec.service.Services;



@RestController
@RequestMapping(value = "/rs")
public class WSLivre extends Services<Livre> {

	private static final String version = "1.0" ;

	private ServiceLivre service;

	public ServiceLivre getService() {
		return service;
	}

	@Autowired
	public void setService(ServiceLivre service) {
		this.service = service;
	}
	
    public WSLivre(){
    }
    
	@RequestMapping(value = "/livres", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllLivres() throws InterruptedException {
		List<Livre> l = service.liste(new Livre());
		System.out.println("Total livre ramené :"+l.size());
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/livres/{Str}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getLivre(@PathVariable("Str") String str) throws InterruptedException {
		System.out.println("Variable str :"+str);
		List<Livre> l = service.selectLike(str);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getVersion", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getVersion(){
		return new ResponseEntity<>("{version:"+version+"}", HttpStatus.OK);
	}
}
