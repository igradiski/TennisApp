package com.hr.igradiski.app.tennis.controller;

import com.hr.igradiski.app.tennis.domain.dto.CourtDto;
import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import com.hr.igradiski.app.tennis.service.CourtService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courts")
@Slf4j
@RequiredArgsConstructor
public class CourtController {

    private final CourtService courtService;

    @PostMapping
    @Operation(summary= "Operation for adding new court")
    public ResponseEntity<CourtDto> addNewCourt(@Validated @RequestBody CourtDto CourtDto){

        log.info("Creating court: "+CourtDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(courtService.addNewCourt(CourtDto));
    }

    @GetMapping
    @Operation(summary= "Operation for fetching filtered courts")
    public Page<CourtDto> getCourtsFiltered(FilterDto filterDto, Pageable pageable){

        log.info("Fetching filtered courts "+filterDto);
        return courtService.getCourtsFiltered(filterDto,pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary= "Operation to fetch court by id")
    public ResponseEntity<CourtDto> getCourtById(@PathVariable("id") Long id){

        log.info("Fetching court with id: "+id);
        return ResponseEntity.status(HttpStatus.OK).body(courtService.getCourtById(id));
    }

    @GetMapping("/all")
    @Operation(summary= "Operation to get all courts")
    public List<CourtDto> getAllCourts(){

        log.info("Fetching all courts ");
        return courtService.getAllCourts();
    }

    @DeleteMapping("/{id}")
    @Operation(summary= "Operation for deleting court by id")
    public ResponseEntity<Object> deleteCourtById(@PathVariable("id") Long id){

        log.info("Deleting court with id : "+ id);
        courtService.deleteCourtById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @Operation(summary= "Operation for deleting courts by list of ids")
    public  ResponseEntity<Object> deleteCourtByIds(@RequestParam(value = "id") List<Long> ids){

        log.info("Deleting courts with id : "+ ids);
        courtService.deleteCourtsByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @Operation(summary= "Operation for court update")
    public ResponseEntity<CourtDto> updateCourt(@RequestBody CourtDto courtDto){

        log.info("Updating court: "+courtDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(courtService.updateCourt(courtDto));
    }

}
