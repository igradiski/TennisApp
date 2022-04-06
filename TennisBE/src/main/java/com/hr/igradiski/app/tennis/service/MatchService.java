package com.hr.igradiski.app.tennis.service;

import com.hr.igradiski.app.tennis.domain.dto.MatchDto;

public interface MatchService {

    MatchDto addNewMatch(MatchDto matchDto);
}
