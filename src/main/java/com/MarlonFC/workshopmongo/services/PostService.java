package com.MarlonFC.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MarlonFC.workshopmongo.domain.Post;
import com.MarlonFC.workshopmongo.repository.PostRepository;
import com.MarlonFC.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Optional<Post> findById(String id) {
		Optional<Post> post = repo.findById(id);
		if (post == null || !post.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post;
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

}
