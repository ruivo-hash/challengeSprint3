package br.com.fiap.cadastrotutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cadastrotutor.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
