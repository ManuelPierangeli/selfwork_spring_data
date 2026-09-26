package it.blog.progetto_blog.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import it.blog.progetto_blog.models.Post;

public interface PostRepository extends ListCrudRepository<Post, Long> {
    List<Post> findByTitle(String title);

    List<Post> findByBody(String body);
}
