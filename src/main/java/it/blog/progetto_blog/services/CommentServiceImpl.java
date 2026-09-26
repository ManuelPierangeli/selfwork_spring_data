package it.blog.progetto_blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import it.blog.progetto_blog.models.Comment;
import it.blog.progetto_blog.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> readAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment read(Long id) {
        Optional<Comment> optComment = commentRepository.findById(id);
        if (optComment.isPresent()) {
            return optComment.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment id= " + id + " not found.");
        }
    }

    @Override
    public List<Comment> read(String body) {
        if (body == null || body.isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return commentRepository.findByBody(body);
    }

    @Override
    public Comment create(Comment comment) {
        if (comment.getBody() == null || comment.getBody().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Long id, Comment comment) {
        if (commentRepository.existsById(id)) {
            comment.setId(id);
            return commentRepository.save(comment);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void delete(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
        }
    }

}
