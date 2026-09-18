package it.blog.progetto_blog.repositories;

import org.springframework.data.repository.CrudRepository;

import it.blog.progetto_blog.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
