package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String save(Course course) {
        courseRepository.save(course);
        return "Uspesno sacuvan kurs";
    }

    @Override
    public String delete(Long id) {
        courseRepository.deleteById(id);
        return "Uspesno obrisan kurs";
    }

    @Override
    public String update(Course course) {
        courseRepository.save(course);
        return "Uspesno sacuvan kurs";
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
