package pt.bitclinic.Javasbmongodb01.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pt.bitclinic.Javasbmongodb01.domain.User;
import pt.bitclinic.Javasbmongodb01.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { // to run when program starts

	// Dependence injection
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//clean Collection
		userRepository.deleteAll();

		// tables seed with dummy data
		User user1 = new User(null, "David Wilson", "david.wilson@examplemail.com");
		User user2 = new User(null, "Olivia Garcia", "olivia.garcia@testmail.com");
		User user3 = new User(null, "James Martinez", "james.martinez@mail.com");
		User user4 = new User(null, "Emma Lopez", "emma.lopez@example.com");
		User user5 = new User(null, "Alexander Turner", "alexander.turner@mail.com");
		User user6 = new User(null, "Ava Mitchell", "ava.mitchell@testmail.com");
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6));
	}

}
