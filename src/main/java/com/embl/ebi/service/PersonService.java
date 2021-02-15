package com.embl.ebi.service;

import com.embl.ebi.dto.PersonDto;
import com.embl.ebi.dto.PersonResponseDto;

import java.util.List;

public interface PersonService {

    PersonResponseDto save(PersonDto personDto);

    PersonResponseDto update(Integer id, PersonDto personDto);

    void delete(Integer id);

    PersonResponseDto findById(Integer id);

    List<PersonResponseDto> list();
}
