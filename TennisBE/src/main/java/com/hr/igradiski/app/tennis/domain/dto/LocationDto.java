package com.hr.igradiski.app.tennis.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class LocationDto {

    public LocationDto() {
    }

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

    private String date;

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
