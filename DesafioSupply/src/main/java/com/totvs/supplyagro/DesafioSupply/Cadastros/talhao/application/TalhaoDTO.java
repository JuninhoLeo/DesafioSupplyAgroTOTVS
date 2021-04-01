package com.totvs.supplyagro.DesafioSupply.Cadastros.talhao.application;

import com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.application.FazendaDTO;
import com.totvs.supplyagro.DesafioSupply.commons.base.application.DataTransferObject;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
public class TalhaoDTO implements DataTransferObject {

    @Getter
    private UUID id;

    @Getter
    private String codigo;

    @Getter
    private Float areaEmHectares;

    @Getter
    private Integer safra;

    @Getter
    private String estimativaDeProdutividade;

    @Getter
    private FazendaDTO fazenda;
}
