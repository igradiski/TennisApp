package com.hr.igradiski.app.tennis.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FilterDto {

    public FilterDto() {
    }

    @NotEmpty
    @Size(min = 3)
    private String name;

    private String dateFrom;

    private String dateUntil;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateUntil() {
        return dateUntil;
    }

    public void setDateUntil(String dateUntil) {
        this.dateUntil = dateUntil;
    }
}
