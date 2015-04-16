package models;

public class ScheduledMatch {
	
	private MockTeam home, away;
	private Integer week;
	private Integer homeGoals, awayGoals;
	
	public ScheduledMatch() {}
	
	public ScheduledMatch(MockTeam home, MockTeam away, Integer week) {
		this.home = home;
		this.away = away;
		this.week = week;
	}

	public MockTeam getHome() {
		return home;
	}

	public void setHome(MockTeam home) {
		this.home = home;
	}

	public MockTeam getAway() {
		return away;
	}

	public void setAway(MockTeam away) {
		this.away = away;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public Integer getHomeGoals() {
		return homeGoals;
	}

	public void setHomeGoals(Integer homeGoals) {
		this.homeGoals = homeGoals;
	}

	public Integer getAwayGoals() {
		return awayGoals;
	}

	public void setAwayGoals(Integer awayGoals) {
		this.awayGoals = awayGoals;
	}
	
}
