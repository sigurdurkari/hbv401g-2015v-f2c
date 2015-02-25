package models;

import java.util.List;
import java.util.ArrayList;

public class Team {
	
	private String name;
	private List<Player> players = new ArrayList<>();
	
	public Team() {}
	
	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	public List<Player> getPlayersByPosition(PlayerPosition pos) {
		List<Player> playersByPos = new ArrayList<>();
		for(Player p : players) {
			if(p.getPosition()==pos) {
				playersByPos.add(p);
			}
		}
		return playersByPos;
	}

}
