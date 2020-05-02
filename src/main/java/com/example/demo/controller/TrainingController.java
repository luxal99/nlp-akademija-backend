package com.example.demo.controller;

import com.example.demo.dao.TrainingDao;
import com.example.demo.entity.OnlineTrainingCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController extends GenericController<OnlineTrainingCheckin> {

    @Autowired
    protected TrainingDao trainingCustomDao;

    @PostMapping("/getByDate")
    public List<OnlineTrainingCheckin> searchClient(@RequestBody Date date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return trainingCustomDao.findAllByIdClientDate(simpleDateFormat.format(date));
        } catch (Exception e) {
            return null;
        }
    }
}
