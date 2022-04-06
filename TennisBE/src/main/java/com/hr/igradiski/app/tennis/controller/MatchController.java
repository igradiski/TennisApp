package com.hr.igradiski.app.tennis.controller;

import com.hr.igradiski.app.tennis.domain.dto.MatchDto;
import com.hr.igradiski.app.tennis.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/matches")
public class MatchController {

    Logger logger = LoggerFactory.getLogger(MatchController.class);
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    @Operation(summary= "Operation to enter a new match")
    public ResponseEntity<MatchDto> addNewMatch(@Validated @RequestBody MatchDto matchDto){

        logger.info("Creating match: "+matchDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(matchService.addNewMatch(matchDto));
    }

}
