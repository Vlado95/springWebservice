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

import fitec.dba.metier.Auteur;
import fitec.service.ServiceAuteur;
import fitec.service.Services;

@RestController
@RequestMapping(value = "/rs")
public class WSAuteur extends Services<Auteur> {

	private static final String version = "1.0" ;
	
/*    private HbnFactory factory;
    
    
    public HbnFactory getFactory() {
		return factory;
	}

    @Autowired
	public void setFactory(HbnFactory factory) {
		this.factory = factory;
	}*/

	private ServiceAuteur service;


	public ServiceAuteur getService() {
		return service;
	}

	@Autowired
	public void setService(ServiceAuteur service) {
		this.service = service;
	}
    
	@RequestMapping(value = "/auteurs", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllAuteurs() throws InterruptedException {
		List<Auteur> l = service.liste(new Auteur());
		System.out.println("Total Auteur ramené :"+l.size());
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auteurs/{Str}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAuteur(@PathVariable("Str") String str) throws InterruptedException {
		List<Auteur> l = service.selectLike(str);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/getVersionA", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody ResponseEntity<?> getServiceVersion(){
//		return new ResponseEntity<>("{version:"+getVersion()+"}", HttpStatus.OK);
//	}
}
