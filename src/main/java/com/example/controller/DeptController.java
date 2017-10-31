package com.example.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.DeptRepository;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/dept/")
@Log
public class DeptController {

	@Inject
	DeptRepository deptrepository;
	
	@GetMapping("/list")
	public String list() {
		log.info("/dept/list");
		
		return "thymeleaf/dept/list";
	}
	
}
