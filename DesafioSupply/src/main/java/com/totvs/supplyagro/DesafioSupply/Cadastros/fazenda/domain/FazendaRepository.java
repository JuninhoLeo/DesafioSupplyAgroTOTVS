package com.totvs.supplyagro.DesafioSupply.Cadastros.fazenda.domain;

import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericRepository;
import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FazendaRepository extends GenericRepository<Fazenda>, JpaRepository<Fazenda, UUID>, ApiJpaRepository<Fazenda> {

}
