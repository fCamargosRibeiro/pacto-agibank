package com.pacto.alegre.empreend.repository;

import com.pacto.alegre.empreend.domain.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
}
