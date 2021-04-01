package com.totvs.supplyagro.DesafioSupply.commons.base.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.ZonedDateTime;
import java.util.UUID;

public class AuditListener {

    @PrePersist
    @PreUpdate
    public void autoFillId(EntityBase entity) {
        if (entity.getId() == null || entity.getId().toString().isEmpty()) {
            entity.setId(UUID.randomUUID());
        }

        entity.setUpdatedAt(ZonedDateTime.now());
    }
}
