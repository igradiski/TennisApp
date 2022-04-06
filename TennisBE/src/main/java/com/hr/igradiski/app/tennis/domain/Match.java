package com.hr.igradiski.app.tennis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name ="MATCH")
public class Match extends AbstractEntity implements Serializable {

    public Match() {
    }

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

    private Boolean matchPlayed;

    private Boolean singles;

    @Column(name = "play_time")
    private Instant playTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Court court;

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

    public List<User> getPlayer1() {
        return player1;
    }

    public void setPlayer1(List<User> player1) {
        this.player1 = player1;
    }

    public List<User> getPlayer2() {
        return player2;
    }

    public void setPlayer2(List<User> player2) {
        this.player2 = player2;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public Boolean getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(Boolean matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public Boolean getSingles() {
        return singles;
    }

    public void setSingles(Boolean singles) {
        this.singles = singles;
    }

    public Instant getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Instant playTime) {
        this.playTime = playTime;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

}
