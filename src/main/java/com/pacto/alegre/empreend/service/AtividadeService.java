package com.pacto.alegre.empreend.service;

import com.pacto.alegre.empreend.domain.Atividade;
import com.pacto.alegre.empreend.repository.AtividadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AtividadeService {
    private final AtividadeRepository atividadeRepository;

    public List<Atividade> findAllAtividade() {
        return atividadeRepository.findAll();
    }
}
