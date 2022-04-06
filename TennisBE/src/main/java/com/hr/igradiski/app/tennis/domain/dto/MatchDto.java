package com.hr.igradiski.app.tennis.domain.dto;

import java.time.Instant;
import java.util.List;


public class MatchDto {

    public MatchDto() {
    }

    private Long id;

    private String name;

    private List<Long> player1;

    private List<Long> player2;

    private List<SetDto> sets;

    private Integer winner;

    private Boolean matchPlayed;

    private Instant playTime;

    private Long court;

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

    public List<Long> getPlayer1() {
        return player1;
    }

    public void setPlayer1(List<Long> player1) {
        this.player1 = player1;
    }

    public List<Long> getPlayer2() {
        return player2;
    }

    public void setPlayer2(List<Long> player2) {
        this.player2 = player2;
    }

    public List<SetDto> getSets() {
        return sets;
    }

    public void setSets(List<SetDto> sets) {
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

    public Instant getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Instant playTime) {
        this.playTime = playTime;
    }

    public Long getCourt() {
        return court;
    }

    public void setCourt(Long court) {
        this.court = court;
    }
}
