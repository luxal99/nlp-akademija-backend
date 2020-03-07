package com.example.demo.service;

import com.example.demo.entity.OnlineCheckIn;
import com.example.demo.entity.OnlinePurchase;
import com.example.demo.entity.Product;
import com.example.demo.repository.OnlinePurchaseRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlinePurchaseServiceImpl implements OnlinePurchaseService {

    @Autowired
    private OnlinePurchaseRepository onlinePurchaseRepository;

    @Autowired
    private ProductService productService;

    @Override
    public String save(OnlinePurchase onlinePurchase, Long[] listOfProductId) {
        for (int i = 0; i < listOfProductId.length; i++) {
            onlinePurchase.setIdProduct(productService.findProductById(listOfProductId[i]));
            onlinePurchaseRepository.save(onlinePurchase);

        }

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
