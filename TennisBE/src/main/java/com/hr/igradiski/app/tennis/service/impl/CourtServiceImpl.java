package com.hr.igradiski.app.tennis.service.impl;

import com.hr.igradiski.app.tennis.domain.Court;
import com.hr.igradiski.app.tennis.domain.dto.CourtDto;
import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import com.hr.igradiski.app.tennis.domain.repository.jpa.CourtRepository;
import com.hr.igradiski.app.tennis.domain.repository.jpa.LocationRepository;
import com.hr.igradiski.app.tennis.domain.specification.CourtSpecification;
import com.hr.igradiski.app.tennis.exception.ObjectAlreadyExists;
import com.hr.igradiski.app.tennis.exception.ObjectNotFound;
import com.hr.igradiski.app.tennis.service.CourtService;
import com.hr.igradiski.app.tennis.service.mapper.CourtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CourtServiceImpl implements CourtService {

    private final CourtRepository courtRepository;
    private final LocationRepository locationRepository;
    private final CourtMapper courtMapper;
    private Logger logger = LoggerFactory.getLogger(CourtServiceImpl.class);

    public CourtServiceImpl(CourtRepository courtRepository, LocationRepository locationRepository, CourtMapper courtMapper) {
        this.courtRepository = courtRepository;
        this.locationRepository = locationRepository;
        this.courtMapper = courtMapper;
    }

    @Override
    @Transactional
    public CourtDto addNewCourt(CourtDto courtDto) {

        if(courtRepository.existsByName(courtDto.getName())){
            logger.error("Court with name; "+courtDto.getName()+" already exists");
            throw new ObjectAlreadyExists("Court with name; "+courtDto.getName()+" already exists");
        }
        var location = locationRepository.findById(courtDto.getLocation())
                .orElseThrow(() -> new ObjectNotFound("Object with id :"+courtDto.getLocation()+ " does not exists"));

        Court court = courtMapper.toEntity(courtDto);
        court.setLocation(location);
        return courtMapper.toDto(courtRepository.save(court));
    }

    @Override
    public Page<CourtDto> getCourtsFiltered(FilterDto filterDto, Pageable pageable) {

        final Specification<Court> specification = CourtSpecification.getCourtSpecification(filterDto);
        return courtRepository.findAll(specification,pageable).map(courtMapper::toDto);
    }

    @Override
    public CourtDto getCourtById(Long id) {

        Court court = courtRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFound("Object with id :"+id+ " does not exists"));
        return courtMapper.toDto(court);
    }

    @Override
    public List<CourtDto> getAllCourts() {

        return courtRepository
                .findAll()
                .stream()
                .map(courtMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteCourtById(Long id) {
        courtRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCourtsByIds(List<Long> ids) {
        courtRepository.deleteByIdIn(ids);
    }

    @Override
    @Transactional
    public CourtDto updateCourt(CourtDto courtDto) {

        Court court = courtRepository.findById(courtDto.getId())
                .orElseThrow(() -> new ObjectNotFound("Object with id :"+courtDto.getId()+ " does not exists"));
        court = courtMapper.updateFromDto(court,courtDto);
        return courtMapper.toDto(courtRepository.save(court));
    }
}
