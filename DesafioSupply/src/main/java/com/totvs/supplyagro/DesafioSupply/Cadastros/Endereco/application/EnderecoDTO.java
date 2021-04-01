package com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.application;

import com.totvs.supplyagro.DesafioSupply.commons.base.application.DataTransferObject;
import lombok.Builder;
import lombok.Getter;

@Builder
public class EnderecoDTO implements DataTransferObject {

    @Getter
    private String cidade;

    @Getter
    private String estado;

    @Getter
    private String logradouro;
}
