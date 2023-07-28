package pt.bitclinic.Javasbmongodb01.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.bitclinic.Javasbmongodb01.domain.Post;

//we don't need to implement this interface, because springframework.data.jpa 
//already has a default implementation for this specific type <User, Long>

public interface PostRepository extends MongoRepository<Post, String> {	
	
	//using Query Methods
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.custom-implementations
	List<Post> findByTitleContainingIgnoreCase(String text);
}

