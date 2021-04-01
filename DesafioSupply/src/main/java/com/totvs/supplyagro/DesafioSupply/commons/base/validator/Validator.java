package com.totvs.supplyagro.DesafioSupply.commons.base.validator;

import com.totvs.supplyagro.DesafioSupply.commons.base.domain.EntityBase;

public interface Validator<ENTITY extends EntityBase, EXCEPTION extends RuntimeException> {

    boolean isValid(ENTITY entity);

    EXCEPTION getException(ENTITY entity);

    default void validate(ENTITY entity) {
        if (!isValid(entity)) {
            throw getException(entity);
        }
    }
}