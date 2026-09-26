package it.blog.progetto_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.blog.progetto_blog.models.Comment;
import it.blog.progetto_blog.services.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.readAll();
    }

    @GetMapping("{id}")
    public Comment getComment(@PathVariable("id") Long id) {
        return commentService.read(id);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @PutMapping
    public Comment updateComment(@PathVariable("id") Long id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.delete(id);
    }
}
