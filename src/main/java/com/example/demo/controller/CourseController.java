package com.example.demo.controller;

import com.example.demo.entity.CourseCheckin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class CourseController extends GenericController<CourseCheckin> {
}
