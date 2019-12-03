package com.example.demo.repository;

import com.example.demo.entity.OnlineCheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineCheckInRepository extends JpaRepository<OnlineCheckIn,Long> {
}
