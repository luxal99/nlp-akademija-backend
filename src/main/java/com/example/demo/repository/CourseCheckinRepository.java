package com.example.demo.repository;

import com.example.demo.entity.CourseCheckin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseCheckinRepository extends JpaRepository<CourseCheckin,Long> {
}
