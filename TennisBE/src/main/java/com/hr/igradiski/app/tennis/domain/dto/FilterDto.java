package com.hr.igradiski.app.tennis.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class FilterDto {

    @NotEmpty
    @Size(min = 3)
    private String name;

    private String dateFrom;

    private String dateUntil;
}
