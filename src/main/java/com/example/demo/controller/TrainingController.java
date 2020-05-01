package com.example.demo.controller;

import com.example.demo.dao.TrainingCustomDao;
import com.example.demo.entity.OnlineTrainingCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController extends GenericController<OnlineTrainingCheckin> {

    @Autowired
    protected TrainingCustomDao trainingCustomDao;

    @PostMapping("/getByDate")
    public ResponseEntity<List<OnlineTrainingCheckin>> searchClient(@RequestBody Date date) {
        return ResponseEntity.ok(trainingCustomDao.findClientByDate(date));
    }
}
