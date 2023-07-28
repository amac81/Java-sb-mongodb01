package pt.bitclinic.Javasbmongodb01.resources;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.bitclinic.Javasbmongodb01.domain.User;
import pt.bitclinic.Javasbmongodb01.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping // or @RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List <User> users = new ArrayList<> ();
		users = service.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		// to generate the correct HTTP response code 201 - Created
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
