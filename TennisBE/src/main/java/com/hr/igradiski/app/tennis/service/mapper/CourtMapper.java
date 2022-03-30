package com.hr.igradiski.app.tennis.service.mapper;

import com.hr.igradiski.app.tennis.domain.Court;
import com.hr.igradiski.app.tennis.domain.dto.CourtDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface CourtMapper {

    @Mapping(target = "location",ignore = true)
    Court toEntity(CourtDto courtDto);

    @Mapping(source = "location.id",target = "location")
    CourtDto toDto(Court court);

    @Mapping(target="court.id",ignore = true)
    @Mapping(target="court.created",ignore = true)
    @Mapping(target="court.updated",ignore = true)
    @Mapping(target ="court.location",ignore = true)
    Court updateFromDto(@MappingTarget Court court, CourtDto courtDto);
}
