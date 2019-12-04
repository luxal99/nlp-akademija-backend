package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String save(Product product) {
        productRepository.save(product);
        return "Uspesno sacuvan seminar";
    }

    @Override
    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Uspesno izbrisan seminar";
    }

    @Override
    public String update(Product product) {
        productRepository.save(product);
        return "Uspesno izmenjen";
    }

    @Override
    public List<Product> getALL() {

        return productRepository.findAll();
    }
}
