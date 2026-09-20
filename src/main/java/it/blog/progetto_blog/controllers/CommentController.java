package it.blog.progetto_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.blog.progetto_blog.models.Comment;
import it.blog.progetto_blog.repositories.CommentRepository;

@RestController
@RequestMapping ("/comments")
public class CommentController {

    @Autowired 
    CommentRepository commentRepository;

    @GetMapping
    List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
}
