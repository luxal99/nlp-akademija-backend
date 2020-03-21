package com.example.demo.service;

import com.example.demo.config.JDBCDatabase;
import com.example.demo.entity.OnlinePurchase;
import com.example.demo.entity.Product;
import com.example.demo.repository.OnlinePurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OnlinePurchaseServiceImpl implements OnlinePurchaseService {

    @Autowired
    private OnlinePurchaseRepository onlinePurchaseRepository;

    @Autowired
    private ProductService productService;

    @Override
    public String save(OnlinePurchase onlinePurchase, Long[] listOfProductId) {
        List<OnlinePurchase> onlinePurchaseList = new ArrayList<>();
        for (int i = 0; i < listOfProductId.length; i++) {
            OnlinePurchase purchase = new OnlinePurchase();
            purchase.setComment(onlinePurchase.getComment());
            purchase.setCountry(onlinePurchase.getCountry());
            purchase.setIdClient(onlinePurchase.getIdClient());
            purchase.setSocialLink(onlinePurchase.getSocialLink());
            Product product = new Product();
            product = productService.findProductById(listOfProductId[i]);
            purchase.setIdProduct(product);
            onlinePurchaseList.add(purchase);
        }
        JDBCDatabase.inserPurchase(onlinePurchaseList);


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
