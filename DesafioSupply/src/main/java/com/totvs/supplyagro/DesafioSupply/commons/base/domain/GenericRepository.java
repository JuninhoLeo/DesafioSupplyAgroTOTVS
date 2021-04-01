package com.totvs.supplyagro.DesafioSupply.commons.base.domain;

import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.ZonedDateTime;
import java.util.UUID;

@NoRepositoryBean
public interface GenericRepository<ENTITY extends EntityBase> extends JpaRepository<ENTITY, UUID>, ApiJpaRepository<ENTITY> {
    Page<ENTITY> findByUpdatedAtGreaterThanEqual(Pageable pageable, ZonedDateTime updatedAt);
}
