package br.com.estudo.springsecurity.exemplo.repositoy;

import br.com.estudo.springsecurity.exemplo.domain.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
