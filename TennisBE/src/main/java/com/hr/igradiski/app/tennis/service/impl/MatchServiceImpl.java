package com.hr.igradiski.app.tennis.service.impl;

import com.hr.igradiski.app.tennis.domain.Match;
import com.hr.igradiski.app.tennis.domain.dto.MatchDto;
import com.hr.igradiski.app.tennis.domain.repository.jpa.CourtRepository;
import com.hr.igradiski.app.tennis.domain.repository.jpa.MatchRepository;
import com.hr.igradiski.app.tennis.domain.repository.jpa.UserRepository;
import com.hr.igradiski.app.tennis.exception.ObjectNotFound;
import com.hr.igradiski.app.tennis.exception.PostFailureException;
import com.hr.igradiski.app.tennis.service.MatchService;
import com.hr.igradiski.app.tennis.service.mapper.MatchMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final UserRepository userRepository;
    private final CourtRepository courtRepository;
    private final MatchMapper matchMapper;
    Logger logger = LoggerFactory.getLogger(MatchServiceImpl.class);

    public MatchServiceImpl(MatchRepository matchRepository, UserRepository userRepository, CourtRepository courtRepository, MatchMapper matchMapper) {
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
        this.courtRepository = courtRepository;
        this.matchMapper = matchMapper;
    }

    @Override
    @Transactional
    public MatchDto addNewMatch(MatchDto matchDto) {

        Match match = matchMapper.toEntity(matchDto);
        if(matchDto.getPlayer1().size() == 2 && matchDto.getPlayer2().size() == 2)
            match.setSingles(false);
        else if(matchDto.getPlayer1().size() == 1 && matchDto.getPlayer2().size() == 1)
            match.setSingles(true);
        else
            throw new PostFailureException("Number of players not valid!");
        match.setPlayer1(userRepository.findAllById(matchDto.getPlayer1()));
        match.setPlayer2(userRepository.findAllById(matchDto.getPlayer2()));
        var court = courtRepository.findById(matchDto.getCourt())
                .orElseThrow(() -> new ObjectNotFound("Court with id: "+matchDto.getCourt()+" does not exists"));
        match.setCourt(court);

        return null;
    }
}
