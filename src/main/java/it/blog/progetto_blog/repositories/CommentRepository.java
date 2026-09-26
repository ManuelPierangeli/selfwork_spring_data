package it.blog.progetto_blog.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import it.blog.progetto_blog.models.Comment;

public interface CommentRepository extends ListCrudRepository<Comment, Long> {
    List<Comment> findByEmail(String email);

    List<Comment> findByBody(String body);
}
