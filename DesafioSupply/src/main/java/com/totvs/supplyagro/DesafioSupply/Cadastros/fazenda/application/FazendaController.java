package com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.application;

import com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.domain.Fazenda;
import com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.domain.FazendaService;
import com.totvs.supplyagro.DesafioSupply.commons.base.application.EntityDTOAssembler;
import com.totvs.supplyagro.DesafioSupply.commons.base.application.GenericController;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericService;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/Fazenda")
@ApiGuideline(ApiGuideline.ApiGuidelineVersion.v1)
@CrossOrigin
public class FazendaController implements GenericController<Fazenda, FazendaDTO> {

    @Autowired
    private FazendaService service;

    @Override
    public GenericService<Fazenda> service(){
        return service;
    }

    @Override
    public Optional<EntityDTOAssembler<Fazenda, FazendaDTO>> assembler(){
        return Optional.of(new FazendaAssembler());
    }
}
