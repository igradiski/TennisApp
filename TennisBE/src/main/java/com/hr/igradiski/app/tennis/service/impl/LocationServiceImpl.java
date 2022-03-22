package com.hr.igradiski.app.tennis.service.impl;

import com.hr.igradiski.app.tennis.domain.repository.jpa.LocationRepository;
import com.hr.igradiski.app.tennis.service.LocationService;
import com.hr.igradiski.app.tennis.service.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper mapper;
}
