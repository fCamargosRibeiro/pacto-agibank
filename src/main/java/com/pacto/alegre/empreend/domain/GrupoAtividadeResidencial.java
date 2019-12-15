package com.pacto.alegre.empreend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grupo_ativ_residencial")
@Getter
@Setter
public class GrupoAtividadeResidencial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oid_grupo_ativ_residencial")
    private Integer oidGrupoAtivResidencial;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Column(name = "unidade")
    private Integer unidade;
    @Column(name = "ga")
    private Integer ga;
    @Column(name = "ano_exercicio")
    private Integer anoExercicio;
    @Column(name = "finalidade")
    private String finalidade;
    @Column(name = "uso")
    private String uso;

}
