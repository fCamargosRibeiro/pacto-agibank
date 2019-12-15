package com.pacto.alegre.empreend.input;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BoletimInput {
    private String logradouro;
    private String numero;
    private String cnae;
}
