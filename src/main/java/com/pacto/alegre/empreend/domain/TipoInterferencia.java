package com.pacto.alegre.empreend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tipo_interferencia")
@Getter
@Setter
public class TipoInterferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oid_tipo_interferencia")
    private Integer oidTipoInterferencia;
    @Basic(optional = false)
    @Column(name = "cod_tipo_interferencia")
    private String codGrupoAtividade;
    @Basic(optional = false)
    @Column(name = "nivel")
    private String nivel;
    @JoinColumn(name = "oid_tipo", referencedColumnName = "oid_tipo")
    @ManyToOne(optional = false)
    private Tipo oidTipo;

}
