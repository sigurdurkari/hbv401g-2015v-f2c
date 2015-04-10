package models;

import java.util.List;
import java.util.ArrayList;

public class MockTeam implements Comparable<MockTeam>{
	
	private String name;
	private List<MockPlayer> players = new ArrayList<>();
	private Integer score;
	
	public MockTeam() {}
	
	public MockTeam(String name) {
		this.name = name;
		score = (int)(Math.random()*30);
	}

	public String getName() {
		return name;
	}
	
	public Integer getScore(){
		return score;
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
	
	public int compareTo(MockTeam team){
		return (team.getScore()).compareTo(this.getScore());
	}
	

}
