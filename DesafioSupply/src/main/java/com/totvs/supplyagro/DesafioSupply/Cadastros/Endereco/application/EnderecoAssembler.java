package com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.application;

import com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.domain.Endereco;
import com.totvs.supplyagro.DesafioSupply.commons.base.application.EntityDTOAssembler;

public class EnderecoAssembler  implements EntityDTOAssembler<Endereco, EnderecoDTO> {

    @Override
    public EnderecoDTO fromEntity(Endereco endereco){

        if(endereco == null){
            return null;
        }

        return EnderecoDTO.builder()
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .logradouro(endereco.getLogradouro())
                .build();
    }

    @Override
    public Endereco fromDTO(EnderecoDTO enderecoDTO){

        if (enderecoDTO == null){
            return null;
        }

        return Endereco.builder()
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .logradouro(enderecoDTO.getLogradouro())
                .build();
    }
}
