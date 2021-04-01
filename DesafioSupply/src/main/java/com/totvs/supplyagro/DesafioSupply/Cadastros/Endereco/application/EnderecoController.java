package com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.application;

import com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.domain.Endereco;
import com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.domain.EnderecoService;
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
@RequestMapping(path = "/Endereco")
@ApiGuideline(ApiGuideline.ApiGuidelineVersion.v1)
@CrossOrigin
public class EnderecoController implements GenericController<Endereco, EnderecoDTO> {

    @Autowired
    private EnderecoService service;

    @Override
    public GenericService<Endereco> service() {
        return service;
    }

    @Override
    public Optional<EntityDTOAssembler<Endereco, EnderecoDTO>> assembler(){
        return Optional.of(new EnderecoAssembler());
    }
}
