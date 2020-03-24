package com.example.demo.service;

import com.example.demo.entity.OnlineTrainingCheckin;
import com.example.demo.repository.OnlineTrainingCheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlineTrainingCheckinServiceImpl implements OnlineTrainingCheckinService {

    @Autowired
    private OnlineTrainingCheckinRepository onlineTrainingCheckinRepository;

    @Override
    public List<OnlineTrainingCheckin> getAll() {
        return onlineTrainingCheckinRepository.findAll();
    }

    @Override
    public String save(OnlineTrainingCheckin onlineTrainingCheckin) {
        onlineTrainingCheckin.setTitle("Online besplatni trening");
        onlineTrainingCheckinRepository.save(onlineTrainingCheckin);
        return "Uspesno ste se prijavili";
    }

    @Override
    public String deleteTrainingCheckin(Long id) {
        onlineTrainingCheckinRepository.deleteById(id);
        return "Uspesno obirsan";
    }
}
