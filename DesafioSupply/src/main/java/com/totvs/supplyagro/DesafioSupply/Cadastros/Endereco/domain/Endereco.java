package com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.domain;

import com.totvs.supplyagro.DesafioSupply.commons.base.domain.AuditListener;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.EntityBase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "Endereco")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditListener.class)
public class Endereco implements EntityBase {

    @Id
    @Getter
    @Setter
    public UUID id;

    @Getter
    @Setter
    private String cidade;

    @Getter
    @Setter
    private String estado;

    @Getter
    @Setter
    private String logradouro;

    @Setter
    @Getter
    private ZonedDateTime updatedAt;

}
