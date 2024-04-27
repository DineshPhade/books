package com.Bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bookstore.entity.Book;

@Repository
public interface Bookrepo extends JpaRepository<Book,Integer> {
    
}
