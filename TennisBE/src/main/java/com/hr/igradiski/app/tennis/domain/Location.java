package com.hr.igradiski.app.tennis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="LOCATION")
public class Location extends AbstractEntity implements Serializable {

    public Location() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_loc")
    @SequenceGenerator(name="seq_loc",allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    private String city;

    @JsonIgnore
    private byte[] picture;

    @Column(name = "picture_name")
    private String pictureName;

    @OneToMany(mappedBy = "location")
    private List<Court> courts;

    private Boolean approved;

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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public List<Court> getCourts() {
        return courts;
    }

    public void setCourts(List<Court> courts) {
        this.courts = courts;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

}
