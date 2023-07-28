package pt.bitclinic.Javasbmongodb01.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import pt.bitclinic.Javasbmongodb01.domain.Post;
import pt.bitclinic.Javasbmongodb01.domain.User;
import pt.bitclinic.Javasbmongodb01.dto.AuthorDTO;
import pt.bitclinic.Javasbmongodb01.dto.CommentDTO;
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
		User user1 = new User(null, "David Wilson", "david.wilson@examplemail.com");
		User user2 = new User(null, "Olivia Garcia", "olivia.garcia@testmail.com");
		User user3 = new User(null, "James Martinez", "james.martinez@mail.com");
		User user4 = new User(null, "Emma Lopez", "emma.lopez@example.com");
		User user5 = new User(null, "Alexander Turner", "alexander.turner@mail.com");
		User user6 = new User(null, "Ava Mitchell", "ava.mitchell@testmail.com");
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6));

		// clean Collection
		postRepository.deleteAll();

		Post post1 = new Post(null, Instant.parse("2023-07-28T10:00:00Z"), "Introduction to AI",
				"Artificial Intelligence (AI) is a rapidly growing field that aims to develop intelligent "
						+ "machines capable of performing tasks that typically require human intelligence.",
				new AuthorDTO(user1));

		Post post2 = new Post(null, Instant.parse("2023-07-27T15:30:00Z"), "The Future of Space Exploration",
				"As technology advances, the prospects for space exploration are becoming more exciting than ever "
						+ "before. Humans are making significant progress in exploring distant planets and even the possibility of interstellar travel",
				new AuthorDTO(user3));

		Post post3 = new Post(null, Instant.parse("2023-07-26T08:45:00Z"), "The Benefits of Meditation",
				"Meditation has been shown to have numerous benefits for both physical and mental health. "
						+ "Regular meditation practice can reduce stress, improve focus, and promote overall well-being.",
				new AuthorDTO(user1));

		Post post4 = new Post(null, Instant.parse("2023-07-25T17:20:00Z"), "Delicious and Healthy Recipes",
				"Eating healthy doesn't mean sacrificing flavor. Try these delicious recipes that are not only "
						+ "tasty but also good for your body. From colorful salads to hearty soups, eating well has never been this enjoyable.",
				new AuthorDTO(user5));

		postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

		user1.getPosts().addAll(Arrays.asList(post1, post3));
		userRepository.save(user1);


		CommentDTO c1 = new CommentDTO("Great post! I found the information about AI fascinating.",
				Instant.parse("2023-07-28T11:30:00Z"), new AuthorDTO(user2));

		CommentDTO c2 = new CommentDTO("I've always been interested in space exploration. Exciting times ahead!",
				Instant.parse("2023-07-27T16:15:00Z"), new AuthorDTO(user4));

		CommentDTO c3 = new CommentDTO("Meditation has changed my life. It's so beneficial for reducing stress.",
				Instant.parse("2023-07-26T09:20:00Z"), new AuthorDTO(user3));

		CommentDTO c4 = new CommentDTO("I can't wait to try these healthy recipes. They sound delicious!",
				Instant.parse("2023-07-25T18:00:00Z"), new AuthorDTO(user6));

		CommentDTO c5 = new CommentDTO("Is there any specific programming language that's best for AI development?",
				Instant.parse("2023-07-28T12:00:00Z"), new AuthorDTO(user1));

		CommentDTO c6 = new CommentDTO("The possibility of exploring other planets is mind-blowing!",
				Instant.parse("2023-07-27T17:30:00Z"), new AuthorDTO(user4));

		CommentDTO c7 = new CommentDTO("I've been meditating for a year now, and it's been a game-changer.",
				Instant.parse("2023-07-26T09:45:00Z"), new AuthorDTO(user5));

		CommentDTO c8 = new CommentDTO("I'm always looking for healthy recipes. Thanks for sharing!",
				Instant.parse("2023-07-25T18:30:00Z"), new AuthorDTO(user2));

		CommentDTO c9 = new CommentDTO("AI ethics is a critical topic. We need to discuss its implications.",
				Instant.parse("2023-07-28T13:20:00Z"), new AuthorDTO(user3));

		CommentDTO c10 = new CommentDTO("Space travel will redefine our understanding of the universe.",
				Instant.parse("2023-07-27T18:45:00Z"), new AuthorDTO(user1));

		post1.getComments().addAll(Arrays.asList(c1, c9, c5));
		post3.getComments().addAll(Arrays.asList(c7, c3));
		post2.getComments().addAll(Arrays.asList(c2, c6, c10));
		post4.getComments().addAll(Arrays.asList(c4, c8));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

	}

}
