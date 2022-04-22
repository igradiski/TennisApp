package com.hr.igradiski.app.tennis.service;

import com.hr.igradiski.app.tennis.domain.dto.CascaderDto;
import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import com.hr.igradiski.app.tennis.domain.dto.LocationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocationService {

    LocationDto addNewLocation(LocationDto locationDto);

    Page<LocationDto> getLocationsFiltered(FilterDto filterDto, Pageable pageable);

    LocationDto getLocationById(Long id);

    List<CascaderDto> getAllLocations();

    LocationDto updateLocation(LocationDto locationDto);

    void deleteLocationById(Long id);

    void deleteLocationByIds(List<Long> ids);
}
