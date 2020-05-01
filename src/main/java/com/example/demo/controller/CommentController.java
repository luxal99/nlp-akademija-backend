package com.example.demo.controller;

import com.example.demo.entity.Comment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController extends GenericController<Comment> {
}
