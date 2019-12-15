package com.pacto.alegre.empreend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author felipe.ribeiro
 */
@Entity
@Table(name = "tipo")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oid_tipo")
    private Integer oidTipo;
    @Basic(optional = false)
    @Column(name = "cod_tipo")
    private String codTipo;
    @Basic(optional = false)
    @Column(name = "desc_tipo")
    private String descTipo;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oidTipo")
    private List<Atividade> atividadeList;
}
