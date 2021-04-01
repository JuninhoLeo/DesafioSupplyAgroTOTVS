package com.totvs.supplyagro.DesafioSupply.commons.base.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.time.ZonedDateTime;
import java.util.UUID;

public interface EntityBase {
    @ApiModelProperty(hidden = true)
    UUID getId();
    void setId(UUID uuid);

    @ApiModelProperty(hidden = true)
    ZonedDateTime getUpdatedAt();
    void setUpdatedAt(ZonedDateTime updatedAt);

    default void setId(String uuid) {
        setId(UUID.fromString(uuid));
    }

    @JsonIgnore
    default String getIdAsString() {
        return getId().toString();
    }

}
