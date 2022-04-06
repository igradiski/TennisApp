package com.hr.igradiski.app.tennis.domain.dto;

public class SetDto {

    public SetDto() {
    }

    private Long id;

    private Integer player1;

    private Integer player2;

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
}
