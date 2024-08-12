package com.matheusfreitas.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusfreitas.workshopmongo.domain.Post;
import com.matheusfreitas.workshopmongo.repository.PostRepository;
import com.matheusfreitas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
	    Optional<Post> optPost = repo.findById(id);
	    if (!optPost.isPresent()) {
	    	throw new ObjectNotFoundException("Objeto não encontrado");
	    }
	    return optPost.get();
	}
	
}
