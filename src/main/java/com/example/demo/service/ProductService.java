package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    public String save(Product product);
    public String delete(Long id);
    public String update(Product product);
    public List<Product> getALL();

}
