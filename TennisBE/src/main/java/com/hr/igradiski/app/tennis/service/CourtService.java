package com.hr.igradiski.app.tennis.service;

import com.hr.igradiski.app.tennis.domain.dto.CourtDto;
import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourtService {

    CourtDto addNewCourt(CourtDto courtDto);

    Page<CourtDto> getCourtsFiltered(FilterDto filterDto, Pageable pageable);

    CourtDto getCourtById(Long id);

    List<CourtDto> getAllCourts();

    void deleteCourtById(Long id);

    void deleteCourtsByIds(List<Long> ids);

    CourtDto updateCourt(CourtDto courtDto);
}
