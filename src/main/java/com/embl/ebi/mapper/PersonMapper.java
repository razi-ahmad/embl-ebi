package com.embl.ebi.mapper;

import com.embl.ebi.dal.entity.PersonEntity;
import com.embl.ebi.dto.PersonDto;
import com.embl.ebi.dto.PersonResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(source = "entity.id",target = "personId")
    PersonResponseDto map(PersonEntity entity);

    PersonEntity map(PersonDto personDto);

    List<PersonResponseDto> map(List<PersonEntity> entities);
}
