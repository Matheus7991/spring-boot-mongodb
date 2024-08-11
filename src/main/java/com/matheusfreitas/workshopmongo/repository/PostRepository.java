package com.matheusfreitas.workshopmongo.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matheusfreitas.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, Serializable>  {

}
