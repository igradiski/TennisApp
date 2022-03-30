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
@EqualsAndHashCode(callSuper = false)
@ToString(onlyExplicitlyIncluded = true)
public class Location extends AbstractEntity implements Serializable {

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

}
