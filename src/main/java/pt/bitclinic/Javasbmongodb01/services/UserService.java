package pt.bitclinic.Javasbmongodb01.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.bitclinic.Javasbmongodb01.domain.User;
import pt.bitclinic.Javasbmongodb01.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Transactional(readOnly = true)	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User insert(User obj) {
		return repo.save(obj);
	}
}