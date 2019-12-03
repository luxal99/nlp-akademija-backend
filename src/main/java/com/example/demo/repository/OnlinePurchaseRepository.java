package com.example.demo.repository;

import com.example.demo.entity.OnlinePurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlinePurchaseRepository extends JpaRepository<OnlinePurchase,Long> {
}
