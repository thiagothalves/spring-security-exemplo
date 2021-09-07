package br.com.estudo.springsecurity.exemplo.controller;

import br.com.estudo.springsecurity.exemplo.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

	private static final List<Student> STUDENTS;

	static {
		STUDENTS = List.of(new Student(1L, "Thiago Alves"), new Student(2L, "Heitor Corrêa"),
				new Student(3L, "Sofia Corrêa"));
	}

	@GetMapping(path = "{id}")
	public Student findStudent(@PathVariable("id") Long id) {
		return STUDENTS.stream().filter(student -> id.equals(student.getId())).findFirst()
				.orElseThrow(() -> new IllegalStateException("Student " + id + " not found!!!"));
	}
}
