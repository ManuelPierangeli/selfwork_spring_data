package it.blog.progetto_blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import it.blog.progetto_blog.models.Post;
import it.blog.progetto_blog.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }

    @Override
    public Post read(Long id) {
        Optional<Post> optPost = postRepository.findById(id);
        if (optPost.isPresent()) {
            return optPost.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post id= " + id + " not found.");
        }
    }

    @Override
    public Post create(Post post) {
        if (post.getTitle() == null || post.getTitle().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return postRepository.save(post);
    }

    @Override
    public Post update(Long id, Post post) {
        if (postRepository.existsById(id)) {
            post.setId(id);
            return postRepository.save(post);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void delete(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
    }
}