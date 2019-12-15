package com.pacto.alegre.empreend.repository;

import com.pacto.alegre.empreend.domain.Tipo;
import com.pacto.alegre.empreend.domain.TipoInterferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipoInterferenciaRepository extends JpaRepository<TipoInterferencia, Long> {
    Optional<TipoInterferencia> findByOidTipoAndNivel(Tipo tipo, String nivel);
}
