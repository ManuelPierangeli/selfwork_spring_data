package it.blog.progetto_blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.blog.progetto_blog.models.Comment;
import it.blog.progetto_blog.services.CommentService;
import it.blog.progetto_blog.services.PostService;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @GetMapping
    public String commentsView(Model viewModel) {
        viewModel.addAttribute("title", "Comments");
        viewModel.addAttribute("comments", commentService.readAll());
        return "comments";
    }

    @GetMapping("create")
    public String createCommentView(Model viewModel) {
        viewModel.addAttribute("title", "Create Comment");
        viewModel.addAttribute("comment", new Comment());
        viewModel.addAttribute("posts", postService.readAll());
        return "commentCreate";
    }

    @PostMapping
    public String createComment(@ModelAttribute("comment") Comment comment) {
        commentService.create(comment);
        return "redirect:/comments";
    }

    @PostMapping("/delete")
    public String deleteComment(@RequestParam("id") Long id) {
        commentService.delete(id);
        return "redirect:/comments";
    }
}