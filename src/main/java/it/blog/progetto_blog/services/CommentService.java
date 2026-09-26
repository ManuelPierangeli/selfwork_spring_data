package it.blog.progetto_blog.services;

import java.util.List;

import it.blog.progetto_blog.models.Comment;

public interface CommentService {

    List<Comment> readAll();

    Comment read(Long id);

    List<Comment> read(String body);

    Comment create(Comment comment);

    Comment update(Long id, Comment comment);

    void delete(Long id);
}
