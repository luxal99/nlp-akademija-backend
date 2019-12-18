package com.example.demo.service;

import com.example.demo.entity.CourseCheckin;
import com.example.demo.repository.CourseCheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseCheckinServiceImpl implements CourseCheckinService {

    @Autowired
    private CourseCheckinRepository courseRepository;

    @Override
    public String save(CourseCheckin course) {
        courseRepository.save(course);
        return "Uspesno sacuvan kurs";
    }

    @Override
    public String delete(Long id) {
        courseRepository.deleteById(id);
        return "Uspesno obrisan kurs";
    }

    @Override
    public String update(CourseCheckin course) {
        courseRepository.save(course);
        return "Uspesno sacuvan kurs";
    }

    @Override
    public List<CourseCheckin> getAll() {
        return courseRepository.findAll();
    }
}
