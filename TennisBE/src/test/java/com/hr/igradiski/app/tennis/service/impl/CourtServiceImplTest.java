package com.hr.igradiski.app.tennis.service.impl;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.hr.igradiski.app.tennis.domain.Court;
import com.hr.igradiski.app.tennis.domain.dto.CourtDto;
import com.hr.igradiski.app.tennis.domain.repository.jpa.CourtRepository;
import com.hr.igradiski.app.tennis.domain.repository.jpa.LocationRepository;
import com.hr.igradiski.app.tennis.exception.ObjectAlreadyExists;
import com.hr.igradiski.app.tennis.exception.ObjectNotFound;
import com.hr.igradiski.app.tennis.service.mapper.CourtMapper;
import com.hr.igradiski.app.tennis.service.mapper.CourtMapperImpl;
import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
@ExtendWith(SpringExtension.class)
class CourtServiceImplTest {


    @MockBean
    private CourtRepository courtRepository;

    @MockBean
    private LocationRepository locationRepository;

    @Mock
    private CourtMapper mapper;

    CourtDto courtDto = new CourtDto();

    @InjectMocks
    private CourtServiceImpl courtServiceTest;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @BeforeEach
    void setUp(){
        courtServiceTest = new CourtServiceImpl(courtRepository,locationRepository,mapper);
        courtDto.setName("Tenisko");
        courtDto.setCovered(true);
        courtDto.setHasLights(true);
    }

    @Test
    void addNewCourt() {
        //courtMapper = new CourtMapperImpl();
        when(courtRepository.existsByName(anyString())).thenThrow(ObjectAlreadyExists.class);
        assertThrows(ObjectAlreadyExists.class, () -> courtServiceTest.addNewCourt(courtDto));

    }

    @Test
    @Disabled
    void getCourtsFiltered() {
    }

    @Test
    void getCourtById() {
        Long id = 1L;
        assertThatThrownBy(() -> courtServiceTest.getCourtById(id))
                .isInstanceOf(ObjectNotFound.class)
                .hasMessageContaining("Object with id :"+id+ " does not exists");
        Court court = mock(Court.class);
        CourtDto courtDto = mock(CourtDto.class);
        CourtMapper mapper = mock(CourtMapper.class);
        when(courtRepository.getById(id)).thenReturn(court);
        when(mapper.toDto(court)).thenReturn(courtDto);
        //assertThat(courtServiceTest.getCourtById(1L)).isEqualTo(courtDto);
    }

    @Test
    void getAllCourts() {
        courtServiceTest.getAllCourts();
        verify(courtRepository).findAll();
    }

    @Test
    void deleteCourtById() {
        Court court = new Court();
        court.setName("Tenisko");
        court.setCovered(true);
        court.setHasLights(true);
        courtServiceTest.deleteCourtById(court.getId());
        verify(courtRepository,times(1)).deleteById(court.getId());

    }

    @Test
    void deleteCourtsByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        courtServiceTest.deleteCourtsByIds(ids);
        verify(courtRepository,times(1)).deleteByIdIn(ids);
    }

    @Test
    void updateCourt() {
        CourtDto courtDto = mock(CourtDto.class);
        assertThatThrownBy(() -> courtServiceTest.updateCourt(courtDto))
                .isInstanceOf(ObjectNotFound.class)
                .hasMessageContaining("Object with id :"+courtDto.getId()+ " does not exists");
    }
}