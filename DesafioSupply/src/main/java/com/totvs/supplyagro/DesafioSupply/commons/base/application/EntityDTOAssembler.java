package com.totvs.supplyagro.DesafioSupply.commons.base.application;

import com.totvs.supplyagro.DesafioSupply.commons.base.domain.EntityBase;

public interface EntityDTOAssembler<ENTITY extends EntityBase, DTO extends DataTransferObject> {
    DTO fromEntity(ENTITY entity);
    ENTITY fromDTO(DTO dto);
}
