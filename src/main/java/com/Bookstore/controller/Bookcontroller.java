package com.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

import com.Bookstore.entity.Book;
import com.Bookstore.entity.Mybooklist;
import com.Bookstore.service.Booklistservice;
import com.Bookstore.service.Bookser;

//import ch.qos.logback.core.model.Model;

//import com.Bookstore.entity.Book;

@Controller
public class Bookcontroller {

    @Autowired
    private Bookser service;

    @Autowired
    private Booklistservice bs;

    @GetMapping("/")
    public String home()
    {
        return "home";

    }
    @GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
	//	ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
    @PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
    @GetMapping("/my_books")
	public String getMyBooks(org.springframework.ui.Model model)
    {
        List<Book>list=service.getAllBook();
		model.addAttribute("book", list);
        return "getMyBooks";
    }
    @RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		Mybooklist mb=new Mybooklist(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		bs.savebook(mb);
		return "redirect:/my_books";
	}
    @RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
    @RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	
    }
