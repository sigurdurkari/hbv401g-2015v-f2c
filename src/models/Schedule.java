package models;

import java.util.List;
import java.util.ArrayList;

public class Schedule {
	
	List<Team> teams = new ArrayList<>();
	List<ScheduledMatch> matches = new ArrayList<>();

	public Schedule() {}
	
	public void makeSchedule() {
		matches = new ArrayList<>();
		Team ghost = new Team("ghost");
		if(teams.size()%2==1) {
			teams.add(ghost);
		}
		for(int week=0; week<teams.size()-1; week++) {
			for(int i=0; i<teams.size()/2; i++) {
				int home = (week + i) % (teams.size() - 1);
	            int away = (teams.size() - 1 - i + week) % (teams.size() - 1);
				matches.add(new ScheduledMatch(teams.get(home),teams.get(away),new Integer(week+1)));
			}
		}
		teams.remove(ghost);
		for(ScheduledMatch match : matches) {
			if(match.getHome().getName().equals(ghost.getName()) || match.getAway().getName().equals(ghost.getName())) {
				matches.remove(match);
			}
		}
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	public void addTeam(Team team) {
		this.teams.add(team);
	}
	
	public void removeTeam(Team team) {
		this.teams.remove(team);
	}

	public List<ScheduledMatch> getMatches() {
		return matches;
	}

	public void setMatches(List<ScheduledMatch> matches) {
		this.matches = matches;
	}
	
	public void addMatch(ScheduledMatch match) {
		this.matches.add(match);
	}
	
	public void removeMatch(ScheduledMatch match) {
		this.matches.remove(match);
	}
	
	public List<ScheduledMatch> getMatchesByWeek(int week) {
		List<ScheduledMatch> weekMatches = new ArrayList<>();
		for(ScheduledMatch match : this.matches) {
			if(week == match.week.intValue()) {
				weekMatches.add(match);
			}
		}
		return weekMatches;
	}
}
