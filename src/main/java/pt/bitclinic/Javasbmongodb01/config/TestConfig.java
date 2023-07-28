package pt.bitclinic.Javasbmongodb01.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import pt.bitclinic.Javasbmongodb01.domain.Comment;
import pt.bitclinic.Javasbmongodb01.domain.Post;
import pt.bitclinic.Javasbmongodb01.domain.User;
import pt.bitclinic.Javasbmongodb01.repositories.CommentRepository;
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

	@Autowired
	private CommentRepository commentRepository;

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

		// clean Collection
		postRepository.deleteAll();

		Post post1 = new Post("p001", Instant.parse("2023-07-28T10:00:00Z"), "Introduction to AI",
				"Artificial Intelligence (AI) is a rapidly growing field that aims to develop intelligent "
						+ "machines capable of performing tasks that typically require human intelligence.",
				user1);

		Post post2 = new Post("p002", Instant.parse("2023-07-27T15:30:00Z"), "The Future of Space Exploration",
				"As technology advances, the prospects for space exploration are becoming more exciting than ever "
						+ "before. Humans are making significant progress in exploring distant planets and even the possibility of interstellar travel",
				user3);

		Post post3 = new Post("p003", Instant.parse("2023-07-26T08:45:00Z"), "The Benefits of Meditation",
				"Meditation has been shown to have numerous benefits for both physical and mental health. "
						+ "Regular meditation practice can reduce stress, improve focus, and promote overall well-being.",
				user2);

		Post post4 = new Post("p004", Instant.parse("2023-07-25T17:20:00Z"), "Delicious and Healthy Recipes",
				"Eating healthy doesn't mean sacrificing flavor. Try these delicious recipes that are not only "
						+ "tasty but also good for your body. From colorful salads to hearty soups, eating well has never been this enjoyable.",
				user5);

		postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

		// clean Collection
		commentRepository.deleteAll();

		Comment c1 = new Comment("c001", "Great post! I found the information about AI fascinating.",
				Instant.parse("2023-07-28T11:30:00Z"), user2);

		Comment c2 = new Comment("c002", "I've always been interested in space exploration. Exciting times ahead!",
				Instant.parse("2023-07-27T16:15:00Z"), user4);

		Comment c3 = new Comment("c003", "Meditation has changed my life. It's so beneficial for reducing stress.",
				Instant.parse("2023-07-26T09:20:00Z"), user3);

		Comment c4 = new Comment("c004", "I can't wait to try these healthy recipes. They sound delicious!",
				Instant.parse("2023-07-25T18:00:00Z"), user6);

		Comment c5 = new Comment("c005", "Is there any specific programming language that's best for AI development?",
				Instant.parse("2023-07-28T12:00:00Z"), user1);

		Comment c6 = new Comment("c006", "The possibility of exploring other planets is mind-blowing!",
				Instant.parse("2023-07-27T17:30:00Z"), user4);

		Comment c7 = new Comment("c007", "I've been meditating for a year now, and it's been a game-changer.",
				Instant.parse("2023-07-26T09:45:00Z"), user5);

		Comment c8 = new Comment("c008", "I'm always looking for healthy recipes. Thanks for sharing!",
				Instant.parse("2023-07-25T18:30:00Z"), user2);

		Comment c9 = new Comment("c009", "AI ethics is a critical topic. We need to discuss its implications.",
				Instant.parse("2023-07-28T13:20:00Z"), user3);

		Comment c10 = new Comment("c010", "Space travel will redefine our understanding of the universe.",
				Instant.parse("2023-07-27T18:45:00Z"), user1);

		commentRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));

	}

}
