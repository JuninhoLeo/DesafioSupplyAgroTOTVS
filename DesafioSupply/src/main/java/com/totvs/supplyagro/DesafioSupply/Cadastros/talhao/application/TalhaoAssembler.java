package com.totvs.supplyagro.DesafioSupply.Cadastros.talhao.application;

import com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.application.FazendaAssembler;
import com.totvs.supplyagro.DesafioSupply.Cadastros.talhao.domain.Talhao;
import com.totvs.supplyagro.DesafioSupply.commons.base.application.EntityDTOAssembler;

public class TalhaoAssembler implements EntityDTOAssembler<Talhao, TalhaoDTO> {

    @Override
    public TalhaoDTO fromEntity(Talhao talhao){

        if(talhao == null){
            return null;
        }

        return TalhaoDTO.builder()
                .id(talhao.getId())
                .codigo(talhao.getCodigo())
                .areaEmHectares(talhao.getAreaEmHectares())
                .safra(talhao.getSafra())
                .estimativaDeProdutividade(talhao.getEstimativaDeProdutividade())
                .fazenda(new FazendaAssembler().fromEntity(talhao.getFazenda()))
                .build();
    }

    @Override
    public Talhao fromDTO(TalhaoDTO talhaoDTO) {

        if (talhaoDTO == null){
            return null;
        }

        return Talhao.builder()
                .id(talhaoDTO.getId())
                .codigo(talhaoDTO.getCodigo())
                .areaEmHectares(talhaoDTO.getAreaEmHectares())
                .safra(talhaoDTO.getSafra())
                .estimativaDeProdutividade(talhaoDTO.getEstimativaDeProdutividade())
                .fazenda(new FazendaAssembler().fromDTO(talhaoDTO.getFazenda()))
                .build();
    }


}
