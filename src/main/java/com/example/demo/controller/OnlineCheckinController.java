package com.example.demo.controller;

import com.example.demo.entity.OnlineCheckIn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("onlineCheckin")
public class OnlineCheckinController extends GenericController<OnlineCheckIn> {
}
