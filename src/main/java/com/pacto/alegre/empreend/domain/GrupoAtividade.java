package com.pacto.alegre.empreend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "grupo_atividade")
@Getter
@Setter
public class GrupoAtividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oid_grupo_atividade")
    private Integer oidGrupoAtividade;
    @Basic(optional = false)
    @Column(name = "cod_grupo_atividade")
    private String codGrupoAtividade;
    @Basic(optional = false)
    @Column(name = "ga")
    private String ga;
    @Basic(optional = false)
    @Column(name = "restricao")
    private String restricao;

}
