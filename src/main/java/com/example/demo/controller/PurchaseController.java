package com.example.demo.controller;

import com.example.demo.entity.OnlinePurchase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController extends GenericController<OnlinePurchase> {
}
