package com.app.sportsConnect.entity;

import jakarta.persistence.Entity;

@Entity
public class BasketballFixture extends Fixture {
    private String team1Score;
    private String team2Score;
    private String matchType;

    public String getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(String team1Score) {
        this.team1Score = team1Score;
    }

    public String getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(String team2Score) {
        this.team2Score = team2Score;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    @Override
    public String toString() {
        return "BasketballFixture{" +
                "team1Score='" + team1Score + '\'' +
                ", team2Score='" + team2Score + '\'' +
                ", matchType='" + matchType + '\'' +
                '}';
    }
}
