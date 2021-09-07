package br.com.estudo.springsecurity.exemplo.controller;

import br.com.estudo.springsecurity.exemplo.domain.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/student")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StudentManagementController {

	private static List<Student> students;

	static {
		students = List.of(new Student(1L, "Thiago Alves"), new Student(2L, "Heitor Corrêa"),
				new Student(3L, "Sofia Corrêa"));
	}

	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public List<Student> findAll() {
		return students;
	}

	@PostMapping
	@PreAuthorize("hasAuthority('student:write')")
	public void create(@RequestBody Student student) {
		students.add(student);
	}

	@DeleteMapping(path = "{id}")
	@PreAuthorize("hasAuthority('student:write')")
	public void remove(@PathVariable("id") Long id) {
		students.removeIf(student -> student.getId().equals(id));
	}

	@PutMapping(path = "{id}")
	@PreAuthorize("hasAuthority('student:write')")
	public void update(@PathVariable("id") Long id, @RequestBody Student student) throws Exception {

		students.forEach(e -> {
			if (e.getId().equals(id)) {
				e.setName(student.getName());
			}
		});

	}
}
