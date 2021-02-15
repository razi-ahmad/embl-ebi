package com.embl.ebi.service.impl;

import com.embl.ebi.dal.PersonRepository;
import com.embl.ebi.dal.entity.PersonEntity;
import com.embl.ebi.dto.PersonDto;
import com.embl.ebi.dto.PersonResponseDto;
import com.embl.ebi.mapper.PersonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


//@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {

    public static final int AGE = 29;
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Keynes";
    public static final String FAVOURITE_COLOR = "red";
    public static final int ID = 1;

    @Mock
    private PersonRepository personRepository;

    private PersonServiceImpl underTestService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);
        underTestService = new PersonServiceImpl(personRepository, personMapper);
    }

    @Test
    public void testSavePerson() {
        PersonDto request = build();
        PersonEntity entity = buildEntity();
        PersonResponseDto expectedResponse = buildExpected();
        when(personRepository.save(ArgumentMatchers.any())).thenReturn(entity);
        PersonResponseDto actualResponse = underTestService.save(request);
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedResponse.getAge(), actualResponse.getAge());
        Assertions.assertEquals(expectedResponse.getFavouriteColor(), actualResponse.getFavouriteColor());
        Assertions.assertEquals(expectedResponse.getFirstName(), actualResponse.getFirstName());
        Assertions.assertEquals(expectedResponse.getLastName(), actualResponse.getLastName());
    }

    @Test
    public void testUpdatePerson() {
        PersonDto request = build();
        request.setAge(10);
        PersonEntity entity = buildEntity();
        entity.setAge(10);
        PersonResponseDto expectedResponse = new PersonResponseDto();
        expectedResponse.setAge(10);
        when(personRepository.findById(ID)).thenReturn(Optional.of(entity));
        PersonResponseDto actualResponse = underTestService.update(ID, request);
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedResponse.getAge(), actualResponse.getAge());
    }

    @Test
    public void testDeletePerson() {
        doNothing().when(personRepository).deleteById(ID);
        underTestService.delete(ID);
        verify(personRepository).deleteById(ID);
    }

    @Test
    public void testFindByIdPerson() {
        PersonEntity entity = buildEntity();
        PersonResponseDto expectedResponse = buildExpected();
        when(personRepository.findById(ID)).thenReturn(Optional.of(entity));
        PersonResponseDto actualResponse = underTestService.findById(ID);
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedResponse.getAge(), actualResponse.getAge());
        Assertions.assertEquals(expectedResponse.getFavouriteColor(), actualResponse.getFavouriteColor());
        Assertions.assertEquals(expectedResponse.getFirstName(), actualResponse.getFirstName());
        Assertions.assertEquals(expectedResponse.getLastName(), actualResponse.getLastName());
    }

    @Test
    public void testListPerson() {
        PersonEntity entity = buildEntity();
        PersonResponseDto expectedResponse = buildExpected();
        when(personRepository.findAll()).thenReturn(List.of(entity));
        List<PersonResponseDto> actualResponse = underTestService.list();
        Assertions.assertNotNull(actualResponse);
        Assertions.assertTrue(actualResponse.size() > 0);
        Assertions.assertEquals(expectedResponse.getAge(), actualResponse.get(0).getAge());
        Assertions.assertEquals(expectedResponse.getFavouriteColor(), actualResponse.get(0).getFavouriteColor());
        Assertions.assertEquals(expectedResponse.getFirstName(), actualResponse.get(0).getFirstName());
        Assertions.assertEquals(expectedResponse.getLastName(), actualResponse.get(0).getLastName());
    }

    private PersonDto build() {
        PersonDto dto = new PersonDto();
        dto.setAge(AGE);
        dto.setFirstName(FIRST_NAME);
        dto.setLastName(LAST_NAME);
        dto.setFavouriteColor(FAVOURITE_COLOR);
        return dto;
    }

    private PersonEntity buildEntity() {
        PersonEntity entity = new PersonEntity();
        entity.setFirstName(FIRST_NAME);
        entity.setLastName(LAST_NAME);
        entity.setAge(AGE);
        entity.setFavouriteColor(FAVOURITE_COLOR);
        entity.setId(ID);
        return entity;
    }

    private PersonResponseDto buildExpected() {
        PersonResponseDto expectedResponse = new PersonResponseDto();
        expectedResponse.setAge(AGE);
        expectedResponse.setFavouriteColor(FAVOURITE_COLOR);
        expectedResponse.setLastName(LAST_NAME);
        expectedResponse.setFirstName(FIRST_NAME);
        return expectedResponse;
    }
}