package com.Bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bookstore.entity.Mybooklist;

@Repository
public interface Mybookrepo extends JpaRepository<Mybooklist,Integer> {
    
}
