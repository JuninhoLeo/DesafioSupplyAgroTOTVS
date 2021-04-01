package com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.domain;

import com.sun.istack.NotNull;
import com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.domain.Endereco;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.AuditListener;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.EntityBase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "fazenda")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditListener.class)
public class Fazenda implements EntityBase {

    @Id
    @Getter
    @Setter
    private UUID id;

    @NotNull
    @Setter
    @Getter
    @Size(max = 200)
    @Column(unique = true)
    private String nome;

    @NotNull
    @Getter
    @CNPJ(message = "CNPJ INVALIDO")
    @Column(unique = true)
    private String cnpj;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Setter
    @Getter
    private ZonedDateTime updatedAt;

}
