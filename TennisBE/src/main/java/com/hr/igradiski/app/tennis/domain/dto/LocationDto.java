package com.hr.igradiski.app.tennis.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDto {

    private Long id;

    private String name;

    private String adress;

    private String city;

    private byte[] picture;

    private String picture_name;
}
