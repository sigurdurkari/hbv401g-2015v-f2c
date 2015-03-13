package models;

import java.util.List;
import java.util.ArrayList;

public class MockTeam {
	
	private String name;
	private List<MockPlayer> players = new ArrayList<>();
	
	public MockTeam() {}
	
	public MockTeam(String name) {
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
