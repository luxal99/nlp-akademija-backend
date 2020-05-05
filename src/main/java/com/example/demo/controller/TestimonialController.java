package com.example.demo.controller;

import com.example.demo.entity.TestimonialImage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testimonial")
public class TestimonialController extends GenericController<TestimonialImage> {

}
