package com.hr.igradiski.app.tennis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="LOCATION")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@ToString(onlyExplicitlyIncluded = true)
public class Location extends AbstractEntity implements Serializable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    private String city;

    @JsonIgnore
    private byte[] picture;

    private String picture_name;

    @OneToMany(mappedBy = "location")
    private List<Court> courts;

}
