package pt.bitclinic.Javasbmongodb01.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.bitclinic.Javasbmongodb01.domain.Comment;

//we don't need to implement this interface, because springframework.data.jpa 
//already has a default implementation for this specific type <User, Long>

public interface CommentRepository extends MongoRepository<Comment, String> {	
}

