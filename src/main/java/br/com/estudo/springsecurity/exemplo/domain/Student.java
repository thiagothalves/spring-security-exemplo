package br.com.estudo.springsecurity.exemplo.domain;

import br.com.estudo.springsecurity.exemplo.dto.StudentDTO;
import br.com.estudo.springsecurity.exemplo.util.AbstractEntity;
import br.com.estudo.springsecurity.exemplo.util.Convertible;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends AbstractEntity implements Convertible<StudentDTO> {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	@Override
	public StudentDTO convert() {
		return new StudentDTO(this);
	}
}
