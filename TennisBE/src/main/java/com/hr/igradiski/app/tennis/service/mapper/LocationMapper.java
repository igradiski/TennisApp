package com.hr.igradiski.app.tennis.service.mapper;

import com.hr.igradiski.app.tennis.domain.Location;
import com.hr.igradiski.app.tennis.domain.dto.CascaderDto;
import com.hr.igradiski.app.tennis.domain.dto.LocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Base64;

@Mapper(componentModel="spring")
public interface LocationMapper{

    default byte[] toByte(String base64){
        return Base64.getDecoder().decode(base64);
    }
    default String toBase64(byte [] data){
        return Base64.getEncoder().encodeToString(data);
    }

    Location toEntity(LocationDto locationDto);

    @Mapping(source ="updated",target = "date")
    LocationDto toDto(Location location);

    @Mapping(source = "id",target = "value")
    @Mapping(source = "name",target = "label")
    @Mapping(source = "id",target = "key")
    CascaderDto toCascaderDto(Location location);

    @Mapping(target="location.id",ignore = true)
    @Mapping(target="location.created",ignore = true)
    Location updateFromDto(@MappingTarget Location location, LocationDto locationDto);
}
