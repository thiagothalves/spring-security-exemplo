package br.com.estudo.springsecurity.exemplo.util;

import javax.persistence.*;

@MappedSuperclass
public abstract class Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
