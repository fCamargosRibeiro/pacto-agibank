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
    private final String RESIDENCIAL_EXCLUSIVO = "0";

    public BoletimOutput validacaoPreviaEndereco(BoletimInput boletimInput) {

        BoletimOutput output = new BoletimOutput();

        if(boletimInput.getCnae() == null){ // PONTO DE REFERENCIA
            Optional<GrupoAtividadeResidencial> optGrupo = grupoAtividadeResidencialRepository.findByLogradouroAndNumero(boletimInput.getLogradouro().toUpperCase(), Integer.parseInt(boletimInput.getNumero()));
            if(optGrupo.isPresent()){
                output.setIsDeferido(optGrupo.get().getUso().equalsIgnoreCase(RESIDENCIAL_EXCLUSIVO));
            }
        } else {
            Optional<GrupoAtividadeResidencial> optGrupo = grupoAtividadeResidencialRepository.findByLogradouroAndNumero(boletimInput.getLogradouro().toUpperCase(), Integer.parseInt(boletimInput.getNumero()));
            Optional<Atividade> optAtividade = atividadeRepository.findBySubclasse(boletimInput.getCnae());
            Optional<TipoInterferencia> optTipo = tipoInterferenciaRepository.findByOidTipoAndCodTipoInterferencia(optAtividade.get().getOidTipo(), optAtividade.get().getInterferencia()) ;
            System.out.println(optTipo.get().getCodGrupoAtividade() + " - - " + optGrupo.get().getGa().toString() );
            Optional<GrupoAtividade> optGrupoAtividade = grupoAtividadeRepository.findByCodGrupoAtividadeAndRestricao(optTipo.get().getCodGrupoAtividade(), optGrupo.get().getGa().toString());


            if(optGrupo.isPresent()){
                output.setIsDeferido(optGrupoAtividade.get().getCodAtividade().equalsIgnoreCase(RESIDENCIAL_EXCLUSIVO));
            }
        }

        output.setMessage(output.getIsDeferido() ? "Deferido" : "Indeferido");

        return output;
    }
}
