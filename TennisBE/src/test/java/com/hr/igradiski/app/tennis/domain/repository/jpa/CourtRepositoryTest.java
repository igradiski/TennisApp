package com.hr.igradiski.app.tennis.domain.repository.jpa;

import com.hr.igradiski.app.tennis.domain.Court;
import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import com.hr.igradiski.app.tennis.domain.specification.CourtSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CourtRepositoryTest {

    @Autowired
    private CourtRepository underTest;
    private String name = "tenisko";
    private String name2 = "nogometno";
    private Court court = new Court();
    private Court court2 = new Court();
    private Pageable pageable = PageRequest.of(0, 5);
    private  FilterDto filterDto = new FilterDto();
    private ArrayList<Long> ids= new ArrayList<>();


    @BeforeEach
     void setUp(){
        underTest.deleteAll();
        court.setId(1L);
        court.setName(name);
        court.setCovered(true);
        court.setHasLights(true);

        court2.setId(2L);
        court2.setName(name2);
        court2.setCovered(true);
        court2.setHasLights(true);

    }

    @Test
    void testExistsByName() {
        underTest.save(court);
        boolean exists = underTest.existsByName(name);
        assertEquals(exists,true);
    }

    @Test
    void findAll() {
        FilterDto filterDto = new FilterDto();
        filterDto.setName("Tenisko");
        filterDto.setDateFrom(Instant.now().toString());
        filterDto.setDateUntil(Instant.now().toString());
        Pageable pageable = PageRequest.of(0, 5);
        underTest.save(court);
        underTest.save(court2);
        Page<Court> page = underTest.findAll(CourtSpecification.getCourtSpecification(filterDto),pageable);
        assertThat(page.getTotalElements() == 1 ).isTrue();
    }

    @Test
    void testDeleteByIdIn() {
        underTest.save(court);
        underTest.save(court2);
        underTest.findAll().forEach(court1 -> {
            ids.add(court1.getId());
        });
        underTest.deleteByIdIn(ids);
        assertThat(underTest.findAll().size() == 0).isTrue();
    }
}