package com.totvs.supplyagro.DesafioSupply.Cadastros.talhao.application;

import com.totvs.supplyagro.DesafioSupply.Cadastros.talhao.domain.Talhao;
import com.totvs.supplyagro.DesafioSupply.Cadastros.talhao.domain.TalhaoService;
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
@RequestMapping(path = "/Talhao")
@ApiGuideline(ApiGuideline.ApiGuidelineVersion.v1)
@CrossOrigin
public class TalhaoController implements GenericController<Talhao, TalhaoDTO> {

    @Autowired
    private TalhaoService service;

    @Override
    public GenericService<Talhao> service() {
        return service;
    }

    @Override
    public Optional<EntityDTOAssembler<Talhao, TalhaoDTO>> assembler(){
        return Optional.of(new TalhaoAssembler());
    }

}
