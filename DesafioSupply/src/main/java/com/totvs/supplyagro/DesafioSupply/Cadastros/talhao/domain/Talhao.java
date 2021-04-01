package com.totvs.supplyagro.DesafioSupply.Cadastros.talhao.domain;

import com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.domain.Fazenda;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.AuditListener;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.EntityBase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "talhao")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditListener.class)
public class Talhao implements EntityBase {

    @Id
    @Getter
    @Setter
    private UUID id;

    @NotNull
    @Getter
    @Setter
    @Size(max = 10)
    private String codigo;

    @NotNull
    @Setter
    @Getter
    private Float areaEmHectares;

    @NotNull
    @Setter
    @Getter
    private Integer safra;

    @NotNull
    @Setter
    @Getter
    private String estimativaDeProdutividade;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "fazenda_id")
    private Fazenda fazenda;

    @Setter
    @Getter
    private ZonedDateTime updatedAt;
}
