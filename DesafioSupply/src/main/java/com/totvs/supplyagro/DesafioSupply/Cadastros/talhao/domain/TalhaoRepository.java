package com.totvs.supplyagro.DesafioSupply.Cadastros.talhao.domain;

import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericRepository;
import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TalhaoRepository extends GenericRepository<Talhao>, JpaRepository<Talhao, UUID>, ApiJpaRepository<Talhao> {

}
