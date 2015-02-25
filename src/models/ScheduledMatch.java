package models;

public class ScheduledMatch {
	
	public Team home, away;
	public Integer week;
	
	public ScheduledMatch() {}
	
	public ScheduledMatch(Team home, Team away, Integer week) {
		this.home = home;
		this.away = away;
		this.week = week;
	}

	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getAway() {
		return away;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}
	
}
