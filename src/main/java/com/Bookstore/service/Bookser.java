package com.Bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookstore.entity.Book;
import com.Bookstore.repository.Bookrepo;

@Service
public class Bookser {
    
@Autowired
private Bookrepo bk;

    public void save(Book b)
    {
        bk.save(b);

    }
    public List<Book> getAllBook(){
      return bk.findAll();
        
    
    }

    public Book getBookById(int id) {
    return bk.findById(id).get();
    }

    public void deleteById(int id) {
      bk.deleteById(id);
    }
}
