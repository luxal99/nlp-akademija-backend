package com.example.demo.dao;

import com.example.demo.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface GenericDao<T extends BaseEntity> extends JpaRepository<T, Serializable> {
}
