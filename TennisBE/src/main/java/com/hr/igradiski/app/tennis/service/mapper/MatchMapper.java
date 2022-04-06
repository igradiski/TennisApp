package com.hr.igradiski.app.tennis.service.mapper;

import com.hr.igradiski.app.tennis.domain.Match;
import com.hr.igradiski.app.tennis.domain.dto.MatchDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface MatchMapper {

    @Mapping(target = "player1",ignore = true)
    @Mapping(target = "player2",ignore = true)
    @Mapping(target = "court",ignore = true)
    Match toEntity(MatchDto matchDto);

    @Mapping(target = "player1",ignore = true)
    @Mapping(target = "player2",ignore = true)
    @Mapping(target = "court",ignore = true)
    MatchDto toDto(Match match);
}
