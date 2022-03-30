package com.hr.igradiski.app.tennis.service.impl;

import com.hr.igradiski.app.tennis.domain.Location;
import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import com.hr.igradiski.app.tennis.domain.dto.LocationDto;
import com.hr.igradiski.app.tennis.domain.repository.jpa.LocationRepository;
import com.hr.igradiski.app.tennis.domain.specification.LocationSpecification;
import com.hr.igradiski.app.tennis.exception.ObjectAlreadyExists;
import com.hr.igradiski.app.tennis.exception.ObjectNotFound;
import com.hr.igradiski.app.tennis.service.LocationService;
import com.hr.igradiski.app.tennis.service.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    @Transactional
    public LocationDto addNewLocation(LocationDto locationDto) {

        if(locationRepository.existsByName(locationDto.getName())){
            log.error("Location with name; "+locationDto.getName()+" already exists");
            throw new ObjectAlreadyExists("Location with name; "+locationDto.getName()+" already exists");
        }
        Location location = locationMapper.toEntity(locationDto);
        return locationMapper.toDto(locationRepository.save(location));
    }

    @Override
    public Page<LocationDto> getLocationsFiltered(FilterDto filterDto, Pageable pageable) {

        final Specification<Location> specification = LocationSpecification.getLocationSpecification(filterDto);
        return locationRepository.findAll(specification,pageable).map(locationMapper::toDto);
    }

    @Override
    public LocationDto getLocationById(Long id) {

        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFound("Object with id :"+id+ " does not exists"));
        return locationMapper.toDto(location);
    }

    @Override
    public List<LocationDto> getAllLocations() {

        return locationRepository
                .findAll()
                .stream()
                .map(locationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LocationDto updateLocation(LocationDto locationDto) {

        Location location = locationRepository.findById(locationDto.getId())
                .orElseThrow(() -> new ObjectNotFound("Object with id :"+locationDto.getId()+ " does not exists"));
        location = locationMapper.updateFromDto(location,locationDto);
        return locationMapper.toDto(locationRepository.save(location));
    }

    @Override
    @Transactional
    public void deleteLocationById(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteLocationByIds(List<Long> ids) {locationRepository.deleteByIdIn(ids);}

}
