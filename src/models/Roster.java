package models;

import java.util.List;
import java.util.ArrayList;

public class Roster {
	
	public static int MIN_GOAL = 1;
	public static int MAX_GOAL = 4;
	public static int MIN_DEFENCE = 3;
	public static int MAX_DEFENCE = 8;
	public static int MIN_MIDFIELD = 3;
	public static int MAX_MIDFIELD = 8;
	public static int MIN_FORWARD = 1;
	public static int MAX_FORWARD = 6;
	public static PlayerPosition[] positions = new PlayerPosition[] {PlayerPosition.GOAL, PlayerPosition.DEFENCE, PlayerPosition.MIDFIELD, PlayerPosition.FORWARD};
	
	private String name;
	private List<MockPlayer> players = new ArrayList<>();
	
	public Roster() {}
	
	public Roster(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MockPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<MockPlayer> players) {
		this.players = players;
	}

	public void addPlayer(MockPlayer player) {
		players.add(player);
	}
	
	public void removePlayer(MockPlayer player) {
		players.remove(player);
	}
	
	public boolean contains(MockPlayer player) {
		return players.contains(player);
	}
	
	public boolean isLegal() {
		if(players.size()!=14) {
			return false;
		}
		if(getPositionCount(PlayerPosition.GOAL) < MIN_GOAL || getPositionCount(PlayerPosition.GOAL) > MAX_GOAL) {
			return false;
		}
		if(getPositionCount(PlayerPosition.DEFENCE) < MIN_DEFENCE || getPositionCount(PlayerPosition.DEFENCE) > MAX_DEFENCE) {
			return false;
		}
		if(getPositionCount(PlayerPosition.MIDFIELD) < MIN_MIDFIELD || getPositionCount(PlayerPosition.MIDFIELD) > MAX_MIDFIELD) {
			return false;
		}
		if(getPositionCount(PlayerPosition.FORWARD) < MIN_FORWARD || getPositionCount(PlayerPosition.FORWARD) > MAX_FORWARD) {
			return false;
		}
		return true;
	}
	
	public int getPositionCount(PlayerPosition position) {
		int count = 0;
		for(MockPlayer p : players) {
			count += p.getPosition()==position ? 1 : 0;
		}
		return count;
	}
	
	public List<MockPlayer> getPlayersByPosition(PlayerPosition pos) {
		List<MockPlayer> playersByPos = new ArrayList<>();
		for(MockPlayer p : players) {
			if(p.getPosition()==pos) {
				playersByPos.add(p);
			}
		}
		return playersByPos;
	}

}
