package br.com.estudo.springsecurity.exemplo.dto;

import br.com.estudo.springsecurity.exemplo.domain.Student;

import javax.validation.constraints.NotNull;

public class StudentDTO {

    public Long id;

    @NotNull
    public String name;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
    }
}
