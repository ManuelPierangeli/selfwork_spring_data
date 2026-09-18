package it.blog.progetto_blog.repositories;

import org.springframework.data.repository.CrudRepository;

import it.blog.progetto_blog.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
