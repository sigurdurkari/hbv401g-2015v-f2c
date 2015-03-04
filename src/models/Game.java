package models;

import java.util.*;

public class Game {
	
	public static Integer STARTING_CASH = 10000000;
	
	private Integer userCount;
	private List<User> users = new ArrayList<>();
	
	private List<Team> teams = new ArrayList<>();
	private Schedule schedule;

	private int activeRound = 0;
	private int activeUser = 0;
	
	public Game() {}
	
	public Game(List<User> users, List<Team> teams) {
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

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
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
	
	public void nextTurn() {
		activeUser = (activeUser+1)%userCount;
		activeRound = activeRound + (activeUser+1)/userCount;
	}
}