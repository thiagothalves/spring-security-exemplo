package br.com.estudo.springsecurity.exemplo.controller;

import br.com.estudo.springsecurity.exemplo.dto.StudentDTO;
import br.com.estudo.springsecurity.exemplo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping(path = "{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable("id") Long id) {
		StudentDTO  find = studentService.findById(id);
		if(find == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok().body(find);
	}

}
