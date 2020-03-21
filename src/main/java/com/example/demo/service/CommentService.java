package com.example.demo.service;

import com.example.demo.entity.Comment;

import java.util.List;

public interface CommentService {
    public String saveComment(Comment comment);
    public List<Comment> getAllComments();
    public String delete(Long id);
}
