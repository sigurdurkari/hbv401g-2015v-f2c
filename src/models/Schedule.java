package models;

import java.util.List;
import java.util.ArrayList;

public class Schedule {
	
	List<MockTeam> teams = new ArrayList<>();
	List<ScheduledMatch> matches = new ArrayList<>();

	public Schedule() {}
	
	public Schedule(List<MockTeam> teams) {
		this.teams = teams;
	}
	
	public void makeSchedule() {
		matches = new ArrayList<>();
		MockTeam ghost = new MockTeam("ghost");
		if(teams.size()%2==1) {
			teams.add(ghost);
		}
		int[] indexes = scheduleIndexes(teams.size());
		for(int week=0; week<teams.size()-1; week++) {
			for(int i=0; i<teams.size()/2; i++) {
				int home = indexes[i];
	            int away = indexes[indexes.length - 1 - i];
				matches.add(new ScheduledMatch(teams.get(home),teams.get(away),new Integer(week+1)));
			}
			indexes = scheduleIndexes(indexes);
		}
		teams.remove(ghost);
		for(ScheduledMatch match : matches) {
			if(match.getHome().getName().equals(ghost.getName()) || match.getAway().getName().equals(ghost.getName())) {
				matches.remove(match);
			}
		}
	}

	public List<MockTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<MockTeam> teams) {
		this.teams = teams;
	}
	
	public void addTeam(MockTeam team) {
		this.teams.add(team);
	}
	
	public void removeTeam(MockTeam team) {
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
			if(week == match.getWeek().intValue()) {
				weekMatches.add(match);
			}
		}
		return weekMatches;
	}
	
	public void playRound(int round) {
		List<ScheduledMatch> matches = getMatchesByWeek(round);
		for(ScheduledMatch m : matches) {
			double randomFactor = Math.random()*3;
			if(randomFactor < 1) {
				m.getHome().addScore(3);
				m.setHomeGoals(1);
				m.setAwayGoals(0);
			} else if(randomFactor < 2) {
				m.getHome().addScore(1);
				m.getAway().addScore(1);
				m.setHomeGoals(0);
				m.setAwayGoals(0);
			} else if(randomFactor < 3) {
				m.getAway().addScore(3);
				m.setHomeGoals(0);
				m.setAwayGoals(1);
			}
		}
	}
	
	private int[] scheduleIndexes(int n) {
		int[] indexes = new int[n];
		for(int i=0; i<n; i++) {
			indexes[i] = i;
		}
		return indexes;
	}
	
	private int[] scheduleIndexes(int[] indexes) {
		int[] newIndexes = new int[indexes.length];
		newIndexes[0] = indexes[0];
		newIndexes[1] = indexes[indexes.length-1];
		for(int i=2; i<indexes.length; i++) {
			newIndexes[i] = indexes[i-1];
		}
		return newIndexes;
	}
}
