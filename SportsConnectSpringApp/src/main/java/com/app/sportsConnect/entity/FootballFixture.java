package com.app.sportsConnect.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class FootballFixture extends Fixture {
    private String score;
    private String matchType;

	//Getters and Setters
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	@Override
	public String toString() {
		return "FootballFixture{" +
				"score='" + score + '\'' +
				", matchType='" + matchType + '\'' +
				'}';
	}
}
