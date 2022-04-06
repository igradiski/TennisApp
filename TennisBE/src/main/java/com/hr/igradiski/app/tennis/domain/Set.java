package com.hr.igradiski.app.tennis.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="SET")
public class Set extends AbstractEntity implements Serializable {

    public Set() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlayer1() {
        return player1;
    }

    public void setPlayer1(Integer player1) {
        this.player1 = player1;
    }

    public Integer getPlayer2() {
        return player2;
    }

    public void setPlayer2(Integer player2) {
        this.player2 = player2;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
