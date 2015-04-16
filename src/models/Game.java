package models;

import java.util.*;

public class Game {
	
	public static Integer STARTING_CASH = 10000000;
	
	private Integer userCount;
	private List<User> users = new ArrayList<>();
	
	private List<MockTeam> teams = new ArrayList<>();
	private Schedule schedule;

	private int activeRound = 0;
	private int activeUser = 0;
	
	public Game() {}
	
	public Game(List<User> users, List<MockTeam> teams) {
		this.userCount = users.size();
		this.users = users;
		this.teams = teams;
		this.schedule = new Schedule(teams);
		this.schedule.makeSchedule();
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<MockTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<MockTeam> teams) {
		this.teams = teams;
	}
	
	public List<MockPlayer> getPlayers() {
		List<MockPlayer> players = new ArrayList<>();
		for(MockTeam t : getTeams()) {
			players.addAll(t.getPlayers());
		}
		Collections.sort(players, new Comparator<MockPlayer>() {
			@Override
			public int compare(MockPlayer lhs, MockPlayer rhs) {
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0 && lhs.getTotalScore().compareTo(rhs.getTotalScore()) == 0) return lhs.getName().compareTo(rhs.getName());
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0) return -lhs.getTotalScore().compareTo(rhs.getTotalScore());
				return lhs.getPosition().compareTo(rhs.getPosition());
			}
		});
		return players;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getActiveRound() {
		return activeRound;
	}

	public void setActiveRound(int activeRound) {
		this.activeRound = activeRound;
	}

	public int getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(int activeUser) {
		this.activeUser = activeUser;
	}
	
	public void setActiveUserName(String name) {
		users.get(activeUser).setUserName(name);
	}
	
	public void setRosterName(String name) {
		users.get(activeUser).getRoster().setName(name);
	}
	
	public void setActiveUser(User user) {
		User u = users.get(activeUser);
		u = new User(user.getUserName(), new Integer(0), STARTING_CASH, user.getRoster());
	}
	
	public void updateUserStats() {
		for(User u : users) {
			u.updateUserStats(activeRound);
		}
	}
	
	public List<MockPlayer> getDreamTeam() {
		if(activeRound<=1) {
			return new ArrayList<>();
		}
		List<MockPlayer> dreamTeam = new ArrayList<>();
		List<MockPlayer> goalkeepers = getPlayersByPosition(getPlayers(), PlayerPosition.GOAL);
		sortByScore(goalkeepers);
		List<MockPlayer> defenders = getPlayersByPosition(getPlayers(), PlayerPosition.DEFENCE);
		sortByScore(defenders);
		List<MockPlayer> midfielders = getPlayersByPosition(getPlayers(), PlayerPosition.MIDFIELD);
		sortByScore(midfielders);
		List<MockPlayer> forwards = getPlayersByPosition(getPlayers(), PlayerPosition.FORWARD);
		sortByScore(forwards);
		dreamTeam.add(goalkeepers.get(0));
		goalkeepers.remove(0);
		dreamTeam.addAll(defenders.subList(0,2));
		defenders.removeAll(defenders.subList(0,2));
		dreamTeam.addAll(midfielders.subList(0,2));
		midfielders.removeAll(midfielders.subList(0,2));
		dreamTeam.add(forwards.get(0));
		forwards.remove(0);
		List<MockPlayer> restOfPlayers = new ArrayList<>();
		restOfPlayers.addAll(defenders.subList(0,3));
		restOfPlayers.addAll(midfielders.subList(0,3));
		restOfPlayers.addAll(forwards.subList(0,2));
		sortByScore(restOfPlayers);
		dreamTeam.addAll(restOfPlayers.subList(0,5));
		return dreamTeam;
	}
	
	public List<MockPlayer> getDreamTeam(int round) {
		if(activeRound<=round) {
			return new ArrayList<>();
		}
		List<MockPlayer> dreamTeam = new ArrayList<>();
		List<MockPlayer> goalkeepers = getPlayersByPosition(getPlayers(), PlayerPosition.GOAL);
		sortByRoundScore(goalkeepers, round);
		List<MockPlayer> defenders = getPlayersByPosition(getPlayers(), PlayerPosition.DEFENCE);
		sortByRoundScore(defenders, round);
		List<MockPlayer> midfielders = getPlayersByPosition(getPlayers(), PlayerPosition.MIDFIELD);
		sortByRoundScore(midfielders, round);
		List<MockPlayer> forwards = getPlayersByPosition(getPlayers(), PlayerPosition.FORWARD);
		sortByRoundScore(forwards, round);
		dreamTeam.add(goalkeepers.get(0));
		goalkeepers.remove(0);
		dreamTeam.addAll(defenders.subList(0,2));
		defenders.removeAll(defenders.subList(0,2));
		dreamTeam.addAll(midfielders.subList(0,2));
		midfielders.removeAll(midfielders.subList(0,2));
		dreamTeam.add(forwards.get(0));
		forwards.remove(0);
		List<MockPlayer> restOfPlayers = new ArrayList<>();
		restOfPlayers.addAll(defenders.subList(0,3));
		restOfPlayers.addAll(midfielders.subList(0,3));
		restOfPlayers.addAll(forwards.subList(0,2));
		sortByRoundScore(restOfPlayers, round);
		dreamTeam.addAll(restOfPlayers.subList(0,5));
		return dreamTeam;
	}
	
	private List<MockPlayer> getPlayersByPosition(List<MockPlayer> players, PlayerPosition pos) {
		List<MockPlayer> playersByPos = new ArrayList<>();
		for(MockPlayer p : players) {
			if(p.getPosition()==pos) {
				playersByPos.add(p);
			}
		}
		return playersByPos;
	}
	
	private void sortByScore(List<MockPlayer> players){
		Collections.sort(players, new Comparator<MockPlayer>() {
			@Override
			public int compare(MockPlayer lhs, MockPlayer rhs) {
				return -lhs.getTotalScore().compareTo(rhs.getTotalScore());
			}
		});
	}
	
	private void sortByRoundScore(List<MockPlayer> players, final int round){
		Collections.sort(players, new Comparator<MockPlayer>() {
			@Override
			public int compare(MockPlayer lhs, MockPlayer rhs) {
				return -lhs.getScores()[round-1].compareTo(rhs.getScores()[round-1]);
			}
		});
	}
	
	private void completeDemoRound() {
		for(MockPlayer p : getPlayers()) {
			p.getScores()[activeRound-1] = (int)(21*Math.random());
		}
		for(User u : users) {
			u.updateUserStats(activeRound);
		}
		schedule.playRound(activeRound);
	}
	
	public void nextTurn() {
		if((activeUser+1)/userCount > 0 && activeRound > 0) {
			completeDemoRound();
		}
		activeRound += (activeUser+1)/userCount;
		activeUser = (activeUser+1)%userCount;
	}
}
