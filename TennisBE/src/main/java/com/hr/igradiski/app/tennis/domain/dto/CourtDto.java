package com.hr.igradiski.app.tennis.domain.dto;


public class CourtDto {

    public CourtDto() {
    }

    private Long id;

    private String name;

    private String type;

    private Boolean isCovered;

    private Boolean hasLights;

    private Long location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getCovered() {
        return isCovered;
    }

    public void setCovered(Boolean covered) {
        isCovered = covered;
    }

    public Boolean getHasLights() {
        return hasLights;
    }

    public void setHasLights(Boolean hasLights) {
        this.hasLights = hasLights;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

}
