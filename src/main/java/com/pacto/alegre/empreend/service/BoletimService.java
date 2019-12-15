package com.pacto.alegre.empreend.service;

import com.pacto.alegre.empreend.input.BoletimInput;
import com.pacto.alegre.empreend.output.BoletimOutput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoletimService {
    public BoletimOutput validacaoPreviaEndereco(BoletimInput boletimInput) {
        return BoletimOutput
                .builder()
                .isDeferido(true)
                .message("teste")
                .build();
    }
}
