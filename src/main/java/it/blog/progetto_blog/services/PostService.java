package it.blog.progetto_blog.services;

import java.util.List;

import it.blog.progetto_blog.models.Post;

public interface PostService {
    List<Post> readAll();

    Post read(Long id);

    Post create(Post post);

    Post update(Long id, Post post);

    void delete(Long id);
}
