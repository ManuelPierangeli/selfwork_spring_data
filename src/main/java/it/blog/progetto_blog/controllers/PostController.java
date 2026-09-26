package it.blog.progetto_blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.blog.progetto_blog.models.Post;
import it.blog.progetto_blog.services.AuthorService;
import it.blog.progetto_blog.services.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    AuthorService authorService;

    @GetMapping
    public String postsView(Model viewModel) {
        viewModel.addAttribute("title", "Posts");
        viewModel.addAttribute("posts", postService.readAll());
        return "posts";
    }

    @GetMapping("create")
    public String createPostView(Model viewModel) {
        viewModel.addAttribute("title", "Create Post");
        viewModel.addAttribute("post", new Post());
        viewModel.addAttribute("authors", authorService.readAll());
        return "postCreate";
    }

    @PostMapping
    public String createPost(@ModelAttribute("post") Post post) {
        postService.create(post);
        return "redirect:/posts";
    }

    @PostMapping("/delete")
    public String deletePost(@RequestParam("id") Long id) {
        postService.delete(id);
        return "redirect:/posts";
    }
}