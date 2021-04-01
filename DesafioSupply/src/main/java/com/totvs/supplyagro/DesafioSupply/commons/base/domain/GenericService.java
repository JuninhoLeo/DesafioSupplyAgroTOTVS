package com.totvs.supplyagro.DesafioSupply.commons.base.domain;

import com.google.common.base.Strings;
import com.totvs.supplyagro.DesafioSupply.exceptions.ApiConstraintViolationException;
import com.totvs.supplyagro.DesafioSupply.exceptions.RecordNotFoundException;
import com.totvs.tjf.api.context.v1.request.ApiFieldRequest;
import com.totvs.tjf.api.context.v1.request.ApiPageRequest;
import com.totvs.tjf.api.context.v1.request.ApiSortRequest;
import com.totvs.tjf.api.context.v1.response.ApiCollectionResponse;
import com.totvs.tjf.core.validation.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class GenericService<ENTITY extends EntityBase> {

    @Autowired
    private ValidatorService validator;

    //@Autowired
    //private ComplexFilterRepository complexFilterRepos;

    public abstract GenericRepository<ENTITY> repository();

    @Transactional
    public ENTITY save(ENTITY entity) {
        validator.validate(entity).ifPresent(violations -> {
            throw new ApiConstraintViolationException(violations);
        });

        beforeSave(entity);

        entity = repository().save(entity);

        afterSave(entity);

        return entity;
    }

    public void beforeSave(ENTITY entity) {
    }

    public void afterSave(ENTITY entity) {
    }

    public void afterUpdate(ENTITY entity) {
    }

    public Optional<ENTITY> findById(UUID id) {
        return repository().findById(id);
    }

    public ApiCollectionResponse<ENTITY> findAll(ApiFieldRequest field, ApiPageRequest page, ApiSortRequest sortRequest, String filter) {
        if (Strings.isNullOrEmpty(filter)) {
            return repository().findAllProjected(field, page, sortRequest);
        } else {
            List<Sort.Order> orders = sortRequest.getOrder()
                    .stream()
                    .map(Sort.Order::by)
                    .collect(Collectors.toList());
            Sort sort = Sort.by(orders);
            PageRequest pageable = PageRequest.of(page.getPage() - 1, page.getPageSize(), sort);
            Page<ENTITY> filtered = findFiltered(pageable, "%".concat(filter).concat("%"));
            return ApiCollectionResponse.<ENTITY>builder().items(filtered.getContent())
                    .hasNext(filtered.hasNext()).build();
        }
    }

    public ApiCollectionResponse<ENTITY> findByUpdatedAt(ApiFieldRequest field, ApiPageRequest page, ApiSortRequest sortRequest, ZonedDateTime updatedAt) {
        if (Objects.isNull(updatedAt)) {
            return repository().findAllProjected(field, page, sortRequest);
        } else {
            List<Sort.Order> orders = sortRequest.getOrder()
                    .stream()
                    .map(Sort.Order::by)
                    .collect(Collectors.toList());
            Sort sort = Sort.by(orders);
            PageRequest pageable = PageRequest.of(page.getPage() - 1, page.getPageSize(), sort);
            Page<ENTITY> filtered = repository().findByUpdatedAtGreaterThanEqual(pageable, updatedAt);
            return ApiCollectionResponse.<ENTITY>builder().items(filtered.getContent()).hasNext(filtered.hasNext()).build();
        }
    }

    public Page<ENTITY> findFiltered(Pageable pageable, String filter) {
        throw new UnsupportedOperationException("Essa funcionalidade precisa ser implementada");
    }

    @Transactional
    public ENTITY update(UUID id, ENTITY entity) {
        GenericRepository<ENTITY> repository = repository();
        ENTITY oldEntity = repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id.toString()));

        entity.setId(oldEntity.getId());

        entity = repository.save(entity);

        afterUpdate(entity);

        return entity;
    }

    public void beforeDelete(ENTITY entity) {
    }

    @Transactional
    public void delete(UUID id) {
        GenericRepository<ENTITY> repository = repository();
        final ENTITY existingEntity = repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id.toString()));
        beforeDelete(existingEntity);
        repository.delete(existingEntity);
    }
}
