package br.com.estudo.springsecurity.exemplo.domain;

import br.com.estudo.springsecurity.exemplo.util.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends AbstractEntity {

	private String name;

	public Student() {
		super();
	}

	public Student(String name) {
		this.name = name;
	}
	public Student(Long id, String name) {
		this.id = id;
		this.name = name;
	}

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

}
