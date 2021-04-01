package com.totvs.supplyagro.DesafioSupply.commons.base.application;

import com.totvs.supplyagro.DesafioSupply.commons.base.documentation.DefaultResponseDocumentation;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.EntityBase;
import com.totvs.supplyagro.DesafioSupply.commons.base.domain.GenericService;
import com.totvs.supplyagro.DesafioSupply.exceptions.RecordNotFoundException;
import com.totvs.tjf.api.context.v1.request.ApiFieldRequest;
import com.totvs.tjf.api.context.v1.request.ApiPageRequest;
import com.totvs.tjf.api.context.v1.request.ApiSortRequest;
import com.totvs.tjf.api.context.v1.response.ApiCollectionResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.QueryParam;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin
public interface GenericController<ENTITY extends EntityBase, DTO extends DataTransferObject> {
    GenericService<ENTITY> service();

    default Optional<EntityDTOAssembler<ENTITY, DTO>> assembler() {
        return Optional.empty();
    }

    @PostMapping
    @DefaultResponseDocumentation
    @ApiOperation("Create an item")
    default ResponseEntity<DTO> create(@RequestBody DTO item) {
        ENTITY entity = entityFromDTO(item);
        ENTITY created = service().save(entity);
        DTO dto = dtoFromEntity(created);

        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/")
                        .path(created.getIdAsString()).build().toUri())
                .body(dto);
    }

    @GetMapping(path = "/{id}")
    @DefaultResponseDocumentation
    @ApiOperation("Retrieve an item by ID")
    default ResponseEntity<DTO> findBy(@PathVariable String id) {
        ENTITY entity = service().findById(UUID.fromString(id))
                .orElseThrow(() -> new RecordNotFoundException(id));
        DTO result = dtoFromEntity(entity);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    @DefaultResponseDocumentation
    @ApiOperation("Retrieve all items")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filter", value = "Filter item.",
                    dataType = "string", paramType = "query")
    })
    default ApiCollectionResponse<DTO> findAll(ApiFieldRequest field, ApiPageRequest page, ApiSortRequest sort, @ApiParam(hidden = true) @QueryParam("filter") String filter) {
        ApiCollectionResponse<ENTITY> entityResult = service().findAll(field, page, sort, filter);

        List<DTO> dtoResult = assembler()
                .map(assembler -> entityResult.getItems()
                        .stream()
                        .map(assembler::fromEntity)
                        .collect(Collectors.toList()))
                .orElse(new ArrayList<>((Collection<? extends DTO>) entityResult.getItems()));

        return ApiCollectionResponse.<DTO>builder()
                .hasNext(entityResult.hasNext())
                .items(dtoResult)
                .build();
    }

    @GetMapping("/updatedAt/{updatedAt}")
    @DefaultResponseDocumentation
    @ApiOperation("Retrieve all items after updated date")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "updatedAt", value = "Filter item.", dataType = "ZonedDateTime", paramType = "path")
    })
    default ApiCollectionResponse<DTO> findByUpdatedAt(ApiFieldRequest field, ApiPageRequest page, ApiSortRequest sort, @ApiParam(hidden = true) @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime updatedAt) {
        ApiCollectionResponse<ENTITY> entityResult = service().findByUpdatedAt(field, page, sort, updatedAt);

        List<DTO> dtoResult = assembler()
                .map(assembler -> entityResult.getItems()
                        .stream()
                        .map(assembler::fromEntity)
                        .collect(Collectors.toList()))
                .orElse(new ArrayList<>((Collection<? extends DTO>) entityResult.getItems()));

        return ApiCollectionResponse.<DTO>builder()
                .hasNext(entityResult.hasNext())
                .items(dtoResult)
                .build();
    }

    @PutMapping("/{id}")
    @DefaultResponseDocumentation
    @ApiOperation("Modify an existing item")
    default ResponseEntity<DTO> update(@PathVariable String id, @RequestBody DTO field) {
        ENTITY entity = entityFromDTO(field);
        ENTITY modified = service().update(UUID.fromString(id), entity);
        return ResponseEntity.ok(dtoFromEntity(modified));
    }

    @DeleteMapping(path = "/{id}")
    @DefaultResponseDocumentation
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @ApiOperation("Remove an existing item")
    default void delete(@PathVariable String id) {
        service().delete(UUID.fromString(id));
    }

    default DTO dtoFromEntity(ENTITY entityResult) {
        final Optional<EntityDTOAssembler<ENTITY, DTO>> assembler = assembler();
        return assembler.isPresent() ? assembler.get().fromEntity(entityResult) : (DTO) entityResult;
    }

    default ENTITY entityFromDTO(@RequestBody DTO item) {
        final Optional<EntityDTOAssembler<ENTITY, DTO>> assembler = assembler();
        return assembler.isPresent() ? assembler.get().fromDTO(item) : (ENTITY) item;
    }
}


