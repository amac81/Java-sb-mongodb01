package pt.bitclinic.Javasbmongodb01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.bitclinic.Javasbmongodb01.domain.Post;
import pt.bitclinic.Javasbmongodb01.repositories.PostRepository;
import pt.bitclinic.Javasbmongodb01.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Transactional(readOnly = true)
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post " + id + " not found."));
	}

	
	@Transactional(readOnly = true)
	public List<Post> findByTitle(String text) {
	//	List<Post> foundPosts = postRepository.findByTitleContainingIgnoreCase(text);
		
		List<Post> foundPosts = postRepository.searchTitle(text);

		return foundPosts;
	}

}