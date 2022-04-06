package com.hr.igradiski.app.tennis.service.mapper;

import com.hr.igradiski.app.tennis.domain.Court;
import com.hr.igradiski.app.tennis.domain.dto.CourtDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CourtMapperTest {

    @Autowired
    private CourtMapper mapper = new CourtMapperImpl();

    @Test
    void toEntity() {
        CourtDto courtDto = new CourtDto();
        courtDto.setName("Tenisko");
        courtDto.setCovered(true);
        courtDto.setHasLights(true);

        Court court = mapper.toEntity(courtDto);
        assertThat(court).hasFieldOrPropertyWithValue("name","Tenisko");
    }

    @Test
    void toDto() {
        Court court = new Court();
        court.setName("Tenisko");
        court.setCovered(true);
        court.setHasLights(true);

        CourtDto courtDto = mapper.toDto(court);
        assertThat(courtDto).hasFieldOrPropertyWithValue("name","Tenisko");
    }

    @Test
    void updateFromDto() {
        Court court = new Court();
        court.setName("Tenisko");
        court.setCovered(true);
        court.setHasLights(true);
        CourtDto courtDto = new CourtDto();
        courtDto.setName("Tenisko2");
        courtDto.setCovered(true);
        courtDto.setHasLights(false);
        Court courtUpdated = mapper.updateFromDto(court,courtDto);
        assertThat(courtUpdated).hasFieldOrPropertyWithValue("name","Tenisko2");
        assertThat(courtUpdated).hasFieldOrPropertyWithValue("hasLights",Boolean.FALSE);
    }
}