package br.com.estudo.springsecurity.exemplo.controller;

import br.com.estudo.springsecurity.exemplo.domain.Student;
import br.com.estudo.springsecurity.exemplo.dto.StudentDTO;
import br.com.estudo.springsecurity.exemplo.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> findAll(
            @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<StudentDTO> studentDTOS = studentService.findAll(pageable);
        if (studentDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
        }

    }


    @GetMapping(path = "{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable("id") Long id) {
        StudentDTO find = studentService.findById(id);
        if (find == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(find);
    }


    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return ResponseEntity.ok().body(studentService.update(id, student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") Long id) {
        studentService.remove(id);
        return ResponseEntity.ok().build();
    }


}
