package com.example.demo.service;

import com.example.demo.entity.OnlineCheckIn;
import com.example.demo.repository.OnlineCheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OnlineCheckInServiceImpl implements OnlineCheckInService {

    @Autowired
    private OnlineCheckInRepository onlineCheckInRepository;
    @Override
    public String save(OnlineCheckIn onlineCheckIn) {
        onlineCheckInRepository.save(onlineCheckIn);
        return "Uspesno ste se prijavili";
    }

    @Override
    public String delete(Long id) {
        onlineCheckInRepository.deleteById(id);
        return "Uspesno obrisana prijava";
    }

    @Override
    public String update(OnlineCheckIn onlineCheckIn) {
        onlineCheckInRepository.save(onlineCheckIn);
        return "Uspesno ste se prijavili";
    }

    @Override
    public List<OnlineCheckIn> getAll() {
        return onlineCheckInRepository.findAll();
    }
}
