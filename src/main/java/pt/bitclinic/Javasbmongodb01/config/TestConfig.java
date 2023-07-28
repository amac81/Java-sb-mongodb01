package pt.bitclinic.Javasbmongodb01.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import pt.bitclinic.Javasbmongodb01.domain.Post;
import pt.bitclinic.Javasbmongodb01.domain.User;
import pt.bitclinic.Javasbmongodb01.repositories.PostRepository;
import pt.bitclinic.Javasbmongodb01.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { // to run when program starts

	// Dependence injection
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// clean Collection
		userRepository.deleteAll();

		// dummy data
		User user1 = new User("64c3d0f2b1e3b51c7857d0d9", "David Wilson", "david.wilson@examplemail.com");
		User user2 = new User("64c3d0f2b1e3b51c7857d0da", "Olivia Garcia", "olivia.garcia@testmail.com");
		User user3 = new User("64c3d0f2b1e3b51c7857d0dc", "James Martinez", "james.martinez@mail.com");
		User user4 = new User("64c3d0f2b1e3b51c7857d0dd", "Emma Lopez", "emma.lopez@example.com");
		User user5 = new User("64c3d0f2b1e3b51c7857d21d", "Alexander Turner", "alexander.turner@mail.com");
		User user6 = new User("64c3d0f2b1e3ba1c7857d0sd", "Ava Mitchell", "ava.mitchell@testmail.com");
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6));

		// Post(String id, Instant moment, String title, String body)

		Post post1 = new Post("p001", Instant.parse("2023-07-28T10:00:00Z"), "Introduction to AI",
				"Artificial Intelligence (AI) is a rapidly growing field that aims to develop intelligent machines capable of performing tasks that typically require human intelligence.");

		Post post2 = new Post("p002", Instant.parse("2023-07-27T15:30:00Z"), "The Future of Space Exploration",
				"As technology advances, the prospects for space exploration are becoming more exciting than ever before. Humans are making significant progress in exploring distant planets and even the possibility of interstellar travel");

		Post post3 = new Post("p003", Instant.parse("2023-07-26T08:45:00Z"), "The Benefits of Meditation",
				"Meditation has been shown to have numerous benefits for both physical and mental health. Regular meditation practice can reduce stress, improve focus, and promote overall well-being.");

		Post post4 = new Post("p004", Instant.parse("2023-07-25T17:20:00Z"), "Delicious and Healthy Recipes",
				"Eating healthy doesn't mean sacrificing flavor. Try these delicious recipes that are not only tasty but also good for your body. From colorful salads to hearty soups, eating well has never been this enjoyable.");
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));
	}

}
