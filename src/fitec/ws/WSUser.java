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

import fitec.dba.metier.User;
import fitec.service.ServiceUser;
import fitec.service.Services;




@RestController
@RequestMapping(value = "/rs")
public class WSUser extends Services<User> {

//	private static final String version = "1.0" ;

	private ServiceUser service;

	public ServiceUser getService() {
		return service;
	}

	@Autowired
	public void setService(ServiceUser service) {
		this.service = service;
	}
	
    public WSUser(){
    }
    
	@RequestMapping(value = "/users", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getAllUsers() throws InterruptedException {
		List<User> l = service.liste(new User());
		System.out.println("Total user ramen� :"+l.size());
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{Str}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getLivre(@PathVariable("Str") String str) throws InterruptedException {
		System.out.println("Variable str :"+str);
		List<User> l = service.selectLike(str);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	
	
	
}
