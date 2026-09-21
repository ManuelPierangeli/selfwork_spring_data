package it.blog.progetto_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.blog.progetto_blog.models.Author;
import it.blog.progetto_blog.models.Comment;
import it.blog.progetto_blog.models.Post;
import it.blog.progetto_blog.repositories.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("{id}")
    public Post getPost(@PathVariable("id") Long id) {
        return postRepository.findById(id).get();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("{id}")
    public Post updatePost(@PathVariable("id") Long id, @RequestBody Post post) {
        post.setId(id);
        return postRepository.save(post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") Long id) {
        if (postRepository.existsById(id)) {
            Post post = postRepository.findById(id).get();

            Author author = post.getAuthor();
            if (author != null) {
                post.setAuthor(null);
            }

            List<Comment> comments = post.getComments();
            if (comments != null) {
                for (Comment comment : comments) {
                    comment.setPost(null);
                }
            }

            postRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
    }
}