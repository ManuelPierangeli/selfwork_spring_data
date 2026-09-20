package it.blog.progetto_blog.repositories;

import org.springframework.data.repository.ListCrudRepository;

import it.blog.progetto_blog.models.Comment;

public interface CommentRepository extends ListCrudRepository<Comment, Long> {

}
