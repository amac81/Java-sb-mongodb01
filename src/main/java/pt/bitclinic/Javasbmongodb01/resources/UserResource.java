package pt.bitclinic.Javasbmongodb01.resources;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.bitclinic.Javasbmongodb01.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	

	@GetMapping // or @RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User user1 = new User("1", "Mary Jane", "mary@gmail.com");
		User user2 = new User("2", "Bob Brown", "bob@gmail.com");
		User user3 = new User("3", "Chris Charlie", "chris@gmail.com");
		User user4 = new User("4", "Louis Bee", "louis@gmail.com");

		List <User> users = new ArrayList<> ();	
		users.addAll(Arrays.asList(user1, user2, user3, user4));
		
		return ResponseEntity.ok().body(users);
	}
}
