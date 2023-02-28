package com.example.tsid.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "jsr330")
public interface BookMapper {

  /**
   * Create a new entity instance from the DTO.
   *
   * @param dto
   * @return a new entity with id set to null since JPA shall generate a new id when saving a new entity to DB
   */
  @Mapping(target = "id", ignore = true)
  BookEntity createNewEntity(BookDto dto);

  /**
   * Update all fields in the entity with values from the DTO except the id since that is not allowed to be updated.
   *
   * @param dto
   * @param entity
   *          - entity to be updated with the values from the DTO
   */
  @Mapping(target = "id", ignore = true)
  void updateEntity(BookDto dto, @MappingTarget BookEntity entity);
}
