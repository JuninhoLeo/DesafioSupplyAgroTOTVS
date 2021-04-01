package com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.application;

import com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.application.EnderecoAssembler;
import com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.domain.Fazenda;
import com.totvs.supplyagro.DesafioSupply.commons.base.application.EntityDTOAssembler;

public class FazendaAssembler implements EntityDTOAssembler<Fazenda, FazendaDTO> {

    @Override
    public FazendaDTO fromEntity(Fazenda fazenda){

        if(fazenda == null){
            return null;
        }

        return FazendaDTO.builder()
                .id(fazenda.getId())
                .nome(fazenda.getNome())
                .cnpj(fazenda.getCnpj())
                .endereco(new EnderecoAssembler().fromEntity(fazenda.getEndereco()))
                .build();
    }

    @Override
    public Fazenda fromDTO(FazendaDTO fazendaDTO){

        if (fazendaDTO == null){
            return null;
        }

        return Fazenda.builder()
                .id(fazendaDTO.getId())
                .nome(fazendaDTO.getNome())
                .cnpj(fazendaDTO.getCnpj())
                .endereco(new EnderecoAssembler().fromDTO(fazendaDTO.getEndereco()))
                .build();
    }
}
