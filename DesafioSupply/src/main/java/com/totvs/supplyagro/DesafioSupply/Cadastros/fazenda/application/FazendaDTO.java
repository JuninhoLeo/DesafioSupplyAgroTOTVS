package com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.application;

import com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.application.EnderecoDTO;
import com.totvs.supplyagro.DesafioSupply.commons.base.application.DataTransferObject;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
public class FazendaDTO implements DataTransferObject {

    @Getter
    private UUID id;

    @Getter
    private String nome;

    @Getter
    private String cnpj;

    @Getter
    private EnderecoDTO endereco;

}
