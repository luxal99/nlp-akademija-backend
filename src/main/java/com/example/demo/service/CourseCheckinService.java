package com.example.demo.service;


import com.example.demo.entity.CourseCheckin;

import java.util.List;

public interface CourseCheckinService {
    public String save(CourseCheckin course);
    public String delete(Long id);
    public String update(CourseCheckin course);
    public List<CourseCheckin> getAll();
}
