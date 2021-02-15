package com.embl.ebi.service.impl;

import com.embl.ebi.dal.PersonRepository;
import com.embl.ebi.dal.entity.PersonEntity;
import com.embl.ebi.dto.PersonDto;
import com.embl.ebi.dto.PersonResponseDto;
import com.embl.ebi.mapper.PersonMapper;
import com.embl.ebi.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    private final PersonMapper mapper;

    @Autowired
    public PersonServiceImpl(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PersonResponseDto save(PersonDto personDto) {
        log.info("Start PersonService -> save(...) Person");
        PersonEntity entity = repository.save(mapper.map(personDto));
        log.info("End PersonService -> save(...)");
        return mapper.map(entity);
    }

    @Override
    @Transactional
    public PersonResponseDto update(Integer id, PersonDto personDto) {
        log.info("Start PersonService -> update(...) Person");
        PersonEntity entity = repository.findById(id).orElseThrow();
        if (personDto.getFirstName() != null) {
            entity.setFirstName(personDto.getFirstName());
        }
        if (personDto.getLastName() != null) {
            entity.setLastName(personDto.getLastName());
        }
        if (personDto.getAge() != null && personDto.getAge() > 0) {
            entity.setAge(personDto.getAge());
        }
        if (personDto.getFavouriteColor() != null) {
            entity.setFavouriteColor(personDto.getFavouriteColor());
        }
        PersonResponseDto response = mapper.map(entity);
        log.info("End PersonService -> update(...)");
        return response;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public PersonResponseDto findById(Integer id) {
        log.info("Start PersonService -> findById(...) personId : {}", id);
        PersonResponseDto response = repository.findById(id)
                .map(mapper::map)
                .orElseThrow();
        log.info("End PersonService -> findById(...)");
        return response;
    }

    @Override
    public List<PersonResponseDto> list() {
        log.info("Start PersonService -> list() ");

        List<PersonResponseDto> response = repository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
        log.info("End PersonService -> list(...)");
        return response;
    }
}
