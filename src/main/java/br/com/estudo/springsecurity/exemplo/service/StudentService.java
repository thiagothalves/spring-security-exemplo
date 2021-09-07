package br.com.estudo.springsecurity.exemplo.service;

import br.com.estudo.springsecurity.exemplo.domain.Student;
import br.com.estudo.springsecurity.exemplo.dto.StudentDTO;
import br.com.estudo.springsecurity.exemplo.repository.StudentRepository;
import br.com.estudo.springsecurity.exemplo.util.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements GenericService<Student, StudentDTO, Long> {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public JpaRepository<Student, Long> getRepository() {
        return studentRepository;
    }
}
