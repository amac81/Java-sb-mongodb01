package pt.bitclinic.Javasbmongodb01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.bitclinic.Javasbmongodb01.domain.User;
import pt.bitclinic.Javasbmongodb01.repositories.UserRepository;
import pt.bitclinic.Javasbmongodb01.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Transactional(readOnly = true)	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(()->  new ObjectNotFoundException("User " + id + " not found."));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
}