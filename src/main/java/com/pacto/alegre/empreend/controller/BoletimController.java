package com.pacto.alegre.empreend.controller;

import com.pacto.alegre.empreend.input.BoletimInput;
import com.pacto.alegre.empreend.service.BoletimService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1")
@CrossOrigin
public class BoletimController {

    private final BoletimService boletimService;

    @GetMapping("previa")
    @ApiOperation(value = "Realizar a validacao prévia do boletim")
    @ApiResponses({@ApiResponse(code = 200, message = "Validacao efetuada com sucesso"),
                   @ApiResponse(code = 500, message = "Erro interno")})
    public ResponseEntity validaPreviaBoletim(BoletimInput boletimInput) {
        return ResponseEntity.ok(boletimService.validacaoPreviaEndereco(boletimInput));
    }
}