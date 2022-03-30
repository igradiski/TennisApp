package com.hr.igradiski.app.tennis.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="MATCH")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@ToString(onlyExplicitlyIncluded = true)
public class Match extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_match")
    @SequenceGenerator(name="seq_match",allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "match")
    private List<User> player1;

    @OneToMany(mappedBy = "match")
    private List<User> player2;

    @OneToMany(mappedBy = "match")
    private List<Set> sets;

    @Column(nullable = false)
    private Integer winner;

    @ManyToOne(fetch = FetchType.LAZY)
    private Court court;

}
