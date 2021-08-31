package br.com.estudo.springsecurity.exemplo.domain;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/estudante")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class EstudanteManagementController {

	private static List<Estudante> estudantes;

	static {
		estudantes = List.of(new Estudante(1L, "Thiago Alves"), new Estudante(2L, "Heitor Corrêa"),
				new Estudante(3L, "Sofia Corrêa"));
	}

	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public List<Estudante> findAll() {
		return estudantes;
	}

	@PostMapping
	@PreAuthorize("hasAuthority('student:write')")
	public void create(@RequestBody Estudante estudante) {
		estudantes.add(estudante);
	}

	@DeleteMapping(path = "{id}")
	@PreAuthorize("hasAuthority('student:write')")
	public void remove(@PathVariable("id") Long id) {
		estudantes.removeIf(estudante -> estudante.getId().equals(id));
	}

	@PutMapping(path = "{id}")
	@PreAuthorize("hasAuthority('student:write')")
	public void update(@PathVariable("id") Long id, @RequestBody Estudante estudante) throws Exception {

		estudantes.forEach(e -> {
			if (e.getId().equals(id)) {
				e.setNome(estudante.getNome());
			}
		});

	}
}
