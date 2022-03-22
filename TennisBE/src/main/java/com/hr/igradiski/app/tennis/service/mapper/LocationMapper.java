package com.hr.igradiski.app.tennis.service.mapper;

import com.hr.igradiski.app.tennis.domain.Location;
import com.hr.igradiski.app.tennis.domain.dto.LocationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface LocationMapper extends EntityMapper<Location, LocationDto>{
}
