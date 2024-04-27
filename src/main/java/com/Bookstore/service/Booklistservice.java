package com.Bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.Bookstore.entity.Book;
//import com.Bookstore.entity.Book;
import com.Bookstore.entity.Mybooklist;
import com.Bookstore.repository.Mybookrepo;

@Service
public class Booklistservice {
   @Autowired  
   private Mybookrepo mb;
     public void savebook(Mybooklist ml)
     {
        mb.save(ml);
     }
     public List<Mybooklist> getAllMyBooks(){
        return mb.findAll();
}
public void deletebyid(int id)
     {
        mb.deleteById(id);
     }

}
