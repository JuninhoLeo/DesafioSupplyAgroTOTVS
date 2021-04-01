package com.totvs.supplyagro.DesafioSupply.Cadastros.Endereco.domain;

import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericRepository;
import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends GenericRepository<Endereco>, JpaRepository<Endereco, UUID>, ApiJpaRepository<Endereco> {
}
