package com.hr.igradiski.app.tennis.service.mapper;

import com.hr.igradiski.app.tennis.domain.Match;
import com.hr.igradiski.app.tennis.domain.dto.MatchDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MatchMapperTest {

    private MatchMapper mapper = new MatchMapperImpl();

    @Test
    void toEntity() {
        MatchDto matchDto = new MatchDto();
        matchDto.setName("Match1");

        Match match = mapper.toEntity(matchDto);
        assertThat(match).hasFieldOrPropertyWithValue("name","Match1");
    }

    @Test
    void toDto() {
        Match match = new Match();
        match.setName("Match1");
        MatchDto dto = mapper.toDto(match);
        assertThat(dto).hasFieldOrPropertyWithValue("name","Match1");
    }
}