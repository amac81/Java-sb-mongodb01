package pt.bitclinic.Javasbmongodb01.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import pt.bitclinic.Javasbmongodb01.domain.Post;

//we don't need to implement this interface, because springframework.data.jpa 
//already has a default implementation for this specific type <User, Long>

public interface PostRepository extends MongoRepository<Post, String> {

	// https://www.mongodb.com/docs/manual/reference/operator/query/regex/
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

	// using Query Methods
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.custom-implementations
	List<Post> findByTitleContainingIgnoreCase(String text);

	// https://www.mongodb.com/docs/manual/reference/operator/query/regex/

	@Query("{ $and: [ { moment: {$gte: ?1 } }, { moment: {$lte: ?2 } }, 	{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, , { 'comments.text': { $regex: ?0, $options: 'i' } } ] }\n"
			+ "] }")
	List<Post> fullSearch(String text, Instant minMoment, Instant maxMoment);

}
