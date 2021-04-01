package com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.domain;

import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericRepository;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends GenericService<Endereco> {

    private EnderecoRepository repository;

    @Override
    public GenericRepository<Endereco> repository(){
        return repository;
    }
}
