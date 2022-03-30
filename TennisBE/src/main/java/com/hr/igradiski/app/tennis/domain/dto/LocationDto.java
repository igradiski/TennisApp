package com.hr.igradiski.app.tennis.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class LocationDto {

    private Long id;

    @NotEmpty
    @Size(min = 3)
    private String name;

    @NotEmpty
    private String adress;

    @NotEmpty
    private String city;

    private String base64;

    private String pictureName;
}
