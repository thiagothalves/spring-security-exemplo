package br.com.estudo.springsecurity.exemplo.domain;

import br.com.estudo.springsecurity.exemplo.util.Entidade;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "estudante")
public class Estudante extends Entidade {

	private String nome;

	public Estudante(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + "]";
	}

}
