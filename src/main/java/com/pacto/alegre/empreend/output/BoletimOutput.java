package com.pacto.alegre.empreend.output;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BoletimOutput {
    private boolean isDeferido;
    private String message;
}
