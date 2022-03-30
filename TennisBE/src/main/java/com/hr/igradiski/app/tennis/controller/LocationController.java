package com.hr.igradiski.app.tennis.controller;

import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import com.hr.igradiski.app.tennis.domain.dto.LocationDto;
import com.hr.igradiski.app.tennis.service.LocationService;
import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.Operation;
import jdk.jfr.Category;
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
@RequestMapping("/locations")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin()
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    @Operation(summary= "Operation for adding new location")
    public ResponseEntity<LocationDto> addNewLocation(@Validated @RequestBody LocationDto locationDto){

        log.info("Creating location: "+locationDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.addNewLocation(locationDto));
    }

    @GetMapping
    @Operation(summary= "Operation for fetching filtered locations")
    public Page<LocationDto> getLocationsFiltered(FilterDto filterDto, Pageable pageable){

        log.info("Fetching filtered locations "+filterDto);
        return locationService.getLocationsFiltered(filterDto,pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary= "Operation to fetch location by id")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable("id") Long id){

        log.info("Fetching location with id: "+id);
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getLocationById(id));
    }

    @GetMapping("/all")
    @Operation(summary= "Operation to get all locations")
    public List<LocationDto> getAllLocations(){

        log.info("Fetching all locations ");
        return locationService.getAllLocations();
    }

    @DeleteMapping("/{id}")
    @Operation(summary= "Operation for deleting location by id")
    public ResponseEntity<Object> deleteLocationById(@PathVariable("id") Long id){

        log.info("Deleting location with id : "+ id);
        locationService.deleteLocationById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @Operation(summary= "Operation for deleting locations by list of ids")
    public  ResponseEntity<Object> deleteLocationByIds(@RequestParam(value = "id") List<Long> ids){

        log.info("Deleting locations with id : "+ ids);
        locationService.deleteLocationByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @Operation(summary= "Operation for location update")
    public ResponseEntity<LocationDto> updateLocation(@RequestBody LocationDto locationDto){

        log.info("Updating location: "+locationDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(locationService.updateLocation(locationDto));
    }

}
