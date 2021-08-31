package br.com.estudo.springsecurity.exemplo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CourseController {

	@GetMapping("courses")
	public String getCourses() {
		return "courses";
	}

}
