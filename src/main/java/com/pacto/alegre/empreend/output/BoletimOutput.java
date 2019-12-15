package com.pacto.alegre.empreend.output;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BoletimOutput {
    private Boolean isDeferido;
    private String message;
}
