package com.pacto.alegre.empreend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author felipe.ribeiro
 */
@Entity
@Table(name = "atividade")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Atividade implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oid_atividade")
    private Integer oidAtividade;
    @Basic(optional = false)
    @Column(name = "codigo_lca")
    private String codigoLca;
    @Basic(optional = false)
    @Column(name = "interferencia")
    private String interferencia;
    @Basic(optional = false)
    @Column(name = "subclasse")
    private String subclasse;

    @JoinColumn(name = "oid_tipo", referencedColumnName = "oid_tipo")
    @ManyToOne(optional = false)
    private Tipo oidTipo;

}
