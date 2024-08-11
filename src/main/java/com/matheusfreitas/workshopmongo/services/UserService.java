package com.matheusfreitas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusfreitas.workshopmongo.domain.User;
import com.matheusfreitas.workshopmongo.dto.UserDTO;
import com.matheusfreitas.workshopmongo.repository.UserRepository;
import com.matheusfreitas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
	    Optional<User> optUser = repo.findById(id); // returns java8 optional
	    if (!optUser.isPresent()) {
	    	throw new ObjectNotFoundException("Objeto não encontrado");
	    }
	    return optUser.get();
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
