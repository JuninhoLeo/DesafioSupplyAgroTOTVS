package com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.domain;

import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericRepository;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FazendaService extends GenericService<Fazenda> {

    private FazendaRepository repository;

    @Override
    public GenericRepository<Fazenda> repository(){
        return repository;
    }
}
