package com.hr.igradiski.app.tennis.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="COURT")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@ToString(onlyExplicitlyIncluded = true)
public class Court extends AbstractEntity implements Serializable {

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    @OneToMany(mappedBy = "court")
    private List<Match> matches;
}
