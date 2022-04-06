package com.hr.igradiski.app.tennis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="COURT")
public class Court extends AbstractEntity implements Serializable {

    public Court() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_crt")
    @SequenceGenerator(name="seq_crt",allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ECourtType type;

    @Column(nullable = false,name = "is_covered")
    private Boolean isCovered;

    @Column(nullable = false,name = "has_lights")
    private Boolean hasLights;

    private Boolean approved;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    @OneToMany(mappedBy = "court")
    private List<Match> matches;

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

    public ECourtType getType() {
        return type;
    }

    public void setType(ECourtType type) {
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

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }


}
