package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public String saveComment(Comment comment) {
        commentRepository.save(comment);
        return "Uspesno poslato pitanje";
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        commentRepository.deleteById(id);
        return "Uspesno obrisan";
    }
}
