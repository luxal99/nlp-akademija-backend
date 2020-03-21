package com.example.demo.service;


import com.example.demo.entity.OnlinePurchase;

import java.util.List;

public interface OnlinePurchaseService {
    public String save(OnlinePurchase onlinePurchase, Long[] listOfProductId) throws InterruptedException;
    public String delete(Long id);
    public String update(OnlinePurchase onlinePurchase);
    public List<OnlinePurchase> getAll();
}
