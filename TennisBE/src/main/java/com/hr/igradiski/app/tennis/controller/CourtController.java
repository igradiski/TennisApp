package com.hr.igradiski.app.tennis.controller;

import com.hr.igradiski.app.tennis.domain.dto.CourtDto;
import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import com.hr.igradiski.app.tennis.service.CourtService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courts")
public class CourtController {


    Logger logger = LoggerFactory.getLogger(CourtController.class);
    private final CourtService courtService;

    public CourtController(CourtService courtService){
        this.courtService = courtService;
    }

    @PostMapping
    @Operation(summary= "Operation to enter a new court")
    public ResponseEntity<CourtDto> addNewCourt(@Validated @RequestBody CourtDto CourtDto){

        logger.info("Creating court: "+CourtDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(courtService.addNewCourt(CourtDto));
    }

    @GetMapping
    @Operation(summary= "Operation for fetching filtered courts")
    public Page<CourtDto> getCourtsFiltered(FilterDto filterDto, Pageable pageable){

        logger.info("Fetching filtered courts "+filterDto);
        return courtService.getCourtsFiltered(filterDto,pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary= "Operation to fetch court by id")
    public ResponseEntity<CourtDto> getCourtById(@PathVariable("id") Long id){

        logger.info("Fetching court with id: "+id);
        return ResponseEntity.status(HttpStatus.OK).body(courtService.getCourtById(id));
    }

    @GetMapping("/all")
    @Operation(summary= "Operation to get all courts")
    public List<CourtDto> getAllCourts(){

        logger.info("Fetching all courts ");
        return courtService.getAllCourts();
    }

    @DeleteMapping("/{id}")
    @Operation(summary= "Operation for deleting court by id")
    public ResponseEntity<Object> deleteCourtById(@PathVariable("id") Long id){

        logger.info("Deleting court with id : "+ id);
        courtService.deleteCourtById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @Operation(summary= "Operation for deleting courts by list of ids")
    public  ResponseEntity<Object> deleteCourtByIds(@RequestParam(value = "id") List<Long> ids){

        logger.info("Deleting courts with id : "+ ids);
        courtService.deleteCourtsByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @Operation(summary= "Operation for court update")
    public ResponseEntity<CourtDto> updateCourt(@RequestBody CourtDto courtDto){

        logger.info("Updating court: "+courtDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(courtService.updateCourt(courtDto));
    }

}
