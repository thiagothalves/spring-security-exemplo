package br.com.estudo.springsecurity.exemplo;

import br.com.estudo.springsecurity.exemplo.domain.Student;
import br.com.estudo.springsecurity.exemplo.repositoy.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentLoader implements ApplicationRunner {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student a1 = new Student("Thiago Alves");
        Student a2 = new Student("Marcela Corrêa");
        Student a3 = new Student("Heitor Corrêa");
        Student a4 = new Student("Sofia Corrêa");
        List<Student> students = List.of(a1, a2, a3, a4);
        studentRepository.saveAll(students);
    }
}
