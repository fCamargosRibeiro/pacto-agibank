package com.pacto.alegre.empreend.service;

import com.pacto.alegre.empreend.domain.Atividade;
import com.pacto.alegre.empreend.domain.GrupoAtividadeResidencial;
import com.pacto.alegre.empreend.input.BoletimInput;
import com.pacto.alegre.empreend.output.BoletimOutput;
import com.pacto.alegre.empreend.repository.AtividadeRepository;
import com.pacto.alegre.empreend.repository.GrupoAtividadeResidencialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BoletimService {

    private GrupoAtividadeResidencialRepository grupoAtividadeResidencialRepository;
    private AtividadeRepository atividadeRepository;
    private final String RESIDENCIAL_EXCLUSIVO = "0";

    public BoletimOutput validacaoPreviaEndereco(BoletimInput boletimInput) {

        BoletimOutput output = new BoletimOutput();

        if(boletimInput.getCnae() == null){ // PONTO DE REFERENCIA
            Optional<GrupoAtividadeResidencial> optGrupo = grupoAtividadeResidencialRepository.findByLogradouroAndNumero(boletimInput.getLogradouro().toUpperCase(), Integer.parseInt(boletimInput.getNumero()));
            if(optGrupo.isPresent()){
                output.setIsDeferido(optGrupo.get().getUso().equalsIgnoreCase(RESIDENCIAL_EXCLUSIVO));
            }
        } else {
            Optional<Atividade> optionalAtividade = atividadeRepository.findBySubclasse(boletimInput.getCnae());
            optionalAtividade = optionalAtividade;
        }

        return output;
    }
}
