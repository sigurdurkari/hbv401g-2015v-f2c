package models;

import java.util.*;

public class Game {
	
	private Integer userCount;
	private List<User> users = new ArrayList<>();
	
	private List<Team> teams = new ArrayList<>();
	private Schedule schedule;

	private int activeWeek;
	private int activeUser;
	
	public Game() {}
	
}
