package com.app.sportsConnect.entity;

import jakarta.persistence.*;

@Entity
public class CricketFixture extends Fixture{
    private String innings1Score;
    private String innings2Score;
    private String matchType;

	public String getInnings1Score() {
		return innings1Score;
	}
	public void setInnings1Score(String innings1Score) {
		this.innings1Score = innings1Score;
	}
	public String getInnings2Score() {
		return innings2Score;
	}
	public void setInnings2Score(String innings2Score) {
		this.innings2Score = innings2Score;
	}
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	@Override
	public String toString() {
		return "CricketFixture{" + "innings1Score='" + innings1Score + '\'' + ", innings2Score='" + innings2Score + '\'' + ", matchType='" + matchType + '\'' + '}';
	}
}
