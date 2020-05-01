package com.example.demo.dao;

import com.example.demo.entity.OnlineTrainingCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class TrainingCustomDaoImpl implements TrainingCustomDao {

    @Autowired
    protected TrainingDao trainingDao;

    @Override
    public List<OnlineTrainingCheckin> findClientByDate(Date date) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String newDate = simpleDateFormat.format(date);
        List<OnlineTrainingCheckin> filteredList = new ArrayList<>();

        for (OnlineTrainingCheckin onlineTrainingCheckin : trainingDao.findAll()) {
            if (onlineTrainingCheckin.getIdClient().getDate().equals(newDate)) {
                filteredList.add(onlineTrainingCheckin);
            }
        }
        return filteredList;
    }
}
