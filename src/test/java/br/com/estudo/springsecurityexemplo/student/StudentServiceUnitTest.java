package br.com.estudo.springsecurityexemplo.student;

import br.com.estudo.springsecurity.exemplo.domain.Student;
import br.com.estudo.springsecurity.exemplo.repository.StudentRepository;
import br.com.estudo.springsecurity.exemplo.service.StudentService;
import br.com.estudo.springsecurityexemplo.utils.TestBaseUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceUnitTest extends TestBaseUtil {

    StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setupEach(){
        this.studentService = new StudentService(this.studentRepository);
    }

    @Test
    void studentServiceTest(){
        var student = new Student();
        student.setId(2L);
        student.setName("Neo");
        Mockito.when(studentRepository.findById(2L)).thenReturn(Optional.of(student));

        var studentDto = studentService.findById(2L);
        assertEquals(studentDto.id, student.getId());
        assertEquals(studentDto.name, student.getName());

    }

}
