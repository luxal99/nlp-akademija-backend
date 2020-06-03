package com.example.demo.controller;


import com.example.demo.dao.FlirtingMasterDao;
import com.example.demo.entity.FlirtingMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flirting")
public class FlirtingMasterController extends GenericController<FlirtingMaster> {

    @Autowired
    protected FlirtingMasterDao flirtingMasterDao;

    @PostMapping("/getByDate")
    public List<FlirtingMaster> searchClient(@RequestBody Date date) {
        return flirtingMasterDao.findAllByIdClientDate(new SimpleDateFormat("dd/MM/yyyy").format(date));
    }
}
