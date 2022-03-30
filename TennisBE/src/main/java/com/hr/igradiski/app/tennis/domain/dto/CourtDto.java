package com.hr.igradiski.app.tennis.domain.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourtDto {

    private Long id;

    private String name;

    private String type;

    private Boolean isCovered;

    private Boolean hasLights;

    private Long location;

}
