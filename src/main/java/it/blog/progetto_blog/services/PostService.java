package it.blog.progetto_blog.services;

import java.util.List;

import it.blog.progetto_blog.dtos.PostDto;
import it.blog.progetto_blog.models.Post;

public interface PostService {
    List<PostDto> readAll();

    PostDto read(Long id);

    PostDto create(Post post);

    PostDto update(Long id, Post post);

    void delete(Long id);
}
