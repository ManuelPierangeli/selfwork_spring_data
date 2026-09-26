package it.blog.progetto_blog.services;

import java.util.List;

import it.blog.progetto_blog.dtos.CommentDto;
import it.blog.progetto_blog.models.Comment;

public interface CommentService {

    List<CommentDto> readAll();

    CommentDto read(Long id);

    List<CommentDto> read(String body);

    CommentDto create(Comment comment);

    CommentDto update(Long id, Comment comment);

    void delete(Long id);
}
