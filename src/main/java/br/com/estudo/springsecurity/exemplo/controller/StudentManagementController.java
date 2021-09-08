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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/student")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StudentManagementController {

    @Autowired
    StudentService studentService;


    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
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
    @PreAuthorize("hasAuthority('student:write')")
    public ResponseEntity<StudentDTO> findById(@PathVariable("id") Long id) {
        StudentDTO find = studentService.findById(id);
        if (find == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(find);
    }


    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public ResponseEntity<StudentDTO> update(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return ResponseEntity.ok().body(studentService.update(id, student));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public ResponseEntity<?> remove(@PathVariable(value = "id") Long id) {
        studentService.remove(id);
        return ResponseEntity.ok().build();
    }


}
