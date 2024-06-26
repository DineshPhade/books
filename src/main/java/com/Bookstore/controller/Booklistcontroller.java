package com.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Bookstore.service.Booklistservice;

@Controller
public class Booklistcontroller {
    @Autowired
	private Booklistservice service;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deletebyid(id);
		return "redirect:/my_books";
	}
}
