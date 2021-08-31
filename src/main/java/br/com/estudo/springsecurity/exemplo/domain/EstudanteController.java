package br.com.estudo.springsecurity.exemplo.domain;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/estudante")
public class EstudanteController {

	private static final List<Estudante> ESTUDANTES;

	static {
		ESTUDANTES = List.of(new Estudante(1L, "Thiago Alves"), new Estudante(2L, "Heitor Corrêa"),
				new Estudante(3L, "Sofia Corrêa"));
	}

	@GetMapping(path = "{id}")
	public Estudante getEstudante(@PathVariable("id") Long id) {
		return ESTUDANTES.stream().filter(estudante -> id.equals(estudante.getId())).findFirst()
				.orElseThrow(() -> new IllegalStateException("Estudante " + id + " não encontrado"));
	}
}
