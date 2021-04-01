package com.totvs.supplyagro.DesafioSupply.Cadastros.talhao.domain;

import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericRepository;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalhaoService extends GenericService<Talhao> {

    @Autowired
    private TalhaoRepository repository;

    @Override
    public GenericRepository<Talhao> repository() {
        return repository;
    }
}
