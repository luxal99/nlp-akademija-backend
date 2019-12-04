package com.example.demo.service;


import com.example.demo.entity.Client;
import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService {
    public String save(Course course);
    public String delete(Long id);
    public String update(Course course);
    public List<Course> getAll();
}
