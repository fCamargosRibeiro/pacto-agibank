package com.pacto.alegre.empreend.repository;

import com.pacto.alegre.empreend.domain.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    Optional<Atividade> findBySubclasse(String subclasse);
}
