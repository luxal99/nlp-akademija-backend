package com.example.demo.service;

import com.example.demo.entity.OnlineCheckIn;
import com.example.demo.entity.OnlinePurchase;
import com.example.demo.repository.OnlinePurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OnlinePurchaseServiceImpl implements OnlinePurchaseService{

    @Autowired
    private OnlinePurchaseRepository onlinePurchaseRepository;

    @Override
    public String save(OnlinePurchase onlinePurchase) {

        onlinePurchaseRepository.save(onlinePurchase);
        return "Uspesno ste porucili";
    }

    @Override
    public String delete(Long id) {
        onlinePurchaseRepository.deleteById(id);
        return "Uspesno obrisana narudzbenica";
    }

    @Override
    public String update(OnlinePurchase onlinePurchase) {
        onlinePurchaseRepository.save(onlinePurchase);
        return "Uspesno ste porucili";
    }

    @Override
    public List<OnlinePurchase> getAll() {
        return onlinePurchaseRepository.findAll();
    }
}
