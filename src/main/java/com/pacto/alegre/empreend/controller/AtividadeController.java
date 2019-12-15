package com.pacto.alegre.empreend.controller;

import com.pacto.alegre.empreend.service.AtividadeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1")
public class AtividadeController {

    private final AtividadeService atividadeService;

    @GetMapping("atividades")
    @ApiOperation(value = "Consultar as atividades disponiveis.")
    @ApiResponses({@ApiResponse(code = 200, message = "Consulta efetuada com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")})
    public ResponseEntity buscarAtividades() {
        return ResponseEntity.ok(atividadeService.findAllAtividade());
    }
}
