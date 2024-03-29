package com.pacto.alegre.empreend.repository;

import com.pacto.alegre.empreend.domain.GrupoAtividadeResidencial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface GrupoAtividadeResidencialRepository extends JpaRepository<GrupoAtividadeResidencial, Long> {
    Optional<GrupoAtividadeResidencial> findByLogradouroContainingAndNumero(String logradouro, Integer numero);
}
