package br.com.estudo.springsecurity.exemplo.repositoy;

import br.com.estudo.springsecurity.exemplo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
