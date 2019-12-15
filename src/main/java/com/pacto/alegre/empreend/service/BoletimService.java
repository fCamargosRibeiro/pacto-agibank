package com.pacto.alegre.empreend.service;

import com.pacto.alegre.empreend.domain.Atividade;
import com.pacto.alegre.empreend.domain.GrupoAtividade;
import com.pacto.alegre.empreend.domain.GrupoAtividadeResidencial;
import com.pacto.alegre.empreend.domain.TipoInterferencia;
import com.pacto.alegre.empreend.input.BoletimInput;
import com.pacto.alegre.empreend.output.BoletimOutput;
import com.pacto.alegre.empreend.repository.AtividadeRepository;
import com.pacto.alegre.empreend.repository.GrupoAtividadeRepository;
import com.pacto.alegre.empreend.repository.GrupoAtividadeResidencialRepository;
import com.pacto.alegre.empreend.repository.TipoInterferenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoletimService {

    private GrupoAtividadeResidencialRepository grupoAtividadeResidencialRepository;
    private AtividadeRepository atividadeRepository;
    private GrupoAtividadeRepository grupoAtividadeRepository;
    private TipoInterferenciaRepository tipoInterferenciaRepository;

    public BoletimOutput validacaoPreviaEndereco(BoletimInput boletimInput) {

        BoletimOutput output = new BoletimOutput();

        String RESIDENCIAL_EXCLUSIVO = "0";
        if(boletimInput.getCnae() == null){ // PONTO DE REFERENCIA
            Optional<GrupoAtividadeResidencial> optGrupo = grupoAtividadeResidencialRepository.findByLogradouroAndNumero(boletimInput.getLogradouro().toUpperCase(), Integer.parseInt(boletimInput.getNumero()));
            if(optGrupo.isPresent()){
                output.setDeferido(optGrupo.get().getUso().equalsIgnoreCase(RESIDENCIAL_EXCLUSIVO));
            }
        } else {
            Optional<GrupoAtividadeResidencial> optGrupo = grupoAtividadeResidencialRepository.findByLogradouroAndNumero(boletimInput.getLogradouro().toUpperCase(), Integer.parseInt(boletimInput.getNumero()));
            Optional<Atividade> optAtividade = atividadeRepository.findBySubclasse(boletimInput.getCnae());

            if(optAtividade.isPresent() && optGrupo.isPresent()) {
                Optional<TipoInterferencia> optTipo = tipoInterferenciaRepository.findByOidTipoAndNivel(optAtividade.get().getOidTipo(), optAtividade.get().getInterferencia());
                if (optTipo.isPresent()) {
                    Optional<GrupoAtividade> optGrupoAtividade = grupoAtividadeRepository.findByCodGrupoAtividadeAndGa(optTipo.get().getCodGrupoAtividade(), optGrupo.get().getGa().toString());
                    if (optGrupo.isPresent()) {
                        output.setDeferido(optGrupoAtividade.get().getRestricao().equalsIgnoreCase(RESIDENCIAL_EXCLUSIVO));
                    }
                }
            }
        }

        output.setMessage(output.isDeferido() ? "Deferido" : "Indeferido");

        return output;
    }
}
