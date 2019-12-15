package com.pacto.alegre.empreend.repository;

import com.pacto.alegre.empreend.domain.GrupoAtividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupoAtividadeRepository extends JpaRepository<GrupoAtividade, Long> {
    Optional<GrupoAtividade> findByCodGrupoAtividadeAndGa(String codGrupoAtividade, String ga);
}
