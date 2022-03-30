package com.hr.igradiski.app.tennis.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="SET")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = false)
@ToString(onlyExplicitlyIncluded = true)
public class Set extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_set")
    @SequenceGenerator(name="seq_set",allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(nullable = false)
    private Integer player1;

    @Column(nullable = false)
    private Integer player2;

    @ManyToOne(fetch = FetchType.LAZY)
    private Match match;

}
