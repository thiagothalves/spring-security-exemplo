package br.com.estudo.springsecurityexemplo.student;

import br.com.estudo.springsecurity.exemplo.domain.Student;
import br.com.estudo.springsecurityexemplo.utils.TestBaseUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


class StudentUnitTest extends TestBaseUtil {

    Student student;

    @BeforeEach
    void setupEach() {
        student = new Student();
        student.setId(1L);
        student.setName("Thiago");
    }


    @Test
    void testStudent() {
        var student = this.student;
        assertEquals(1, student.getId());
        assertEquals("Thiago", student.getName());
    }


}
