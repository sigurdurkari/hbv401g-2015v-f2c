package models;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Roster {
	
	public static int MIN_GOAL = 1;
	public static int MAX_GOAL = 2;
	public static int MIN_DEFENCE = 3;
	public static int MAX_DEFENCE = 8;
	public static int MIN_MIDFIELD = 3;
	public static int MAX_MIDFIELD = 8;
	public static int MIN_FORWARD = 1;
	public static int MAX_FORWARD = 6;
	public static PlayerPosition[] positions = new PlayerPosition[] {PlayerPosition.GOAL, PlayerPosition.DEFENCE, PlayerPosition.MIDFIELD, PlayerPosition.FORWARD};
	
	private String name;
	private List<MockPlayer> players = new ArrayList<>();
	private List<MockPlayer> onField = new ArrayList<>();
	private List<MockPlayer> subs = new ArrayList<>();
	private MockPlayer captain;
	
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
		this.onField = players.subList(0, 11);
		this.subs = players.subList(11, players.size());
		sort();
	}

	public void addPlayer(MockPlayer player) {
		players.add(player);
		if(onField.size() < 11) {
			onField.add(player);
		} else {
			subs.add(player);
		}
		sort();
	}
	
	public void removePlayer(MockPlayer player) {
		players.remove(player);
		onField.remove(player);
		subs.remove(player);
	}
	
	public boolean contains(MockPlayer player) {
		return players.contains(player);
	}
	
	public List<MockPlayer> getOnField() {
		return onField;
	}

	public void setOnField(List<MockPlayer> onField) {
		this.onField = onField;
	}

	public List<MockPlayer> getSubs() {
		return subs;
	}

	public void setSubs(List<MockPlayer> subs) {
		this.subs = subs;
	}

	public MockPlayer getCaptain() {
		return captain;
	}

	public void setCaptain(MockPlayer captain) {
		this.captain = captain;
	}

	private void sort() {
		Collections.sort(players, new Comparator<MockPlayer>() {
			@Override
			public int compare(MockPlayer lhs, MockPlayer rhs) {
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0 && lhs.getTotalScore().compareTo(rhs.getTotalScore()) == 0) return lhs.getName().compareTo(rhs.getName());
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0) return -lhs.getTotalScore().compareTo(rhs.getTotalScore());
				return lhs.getPosition().compareTo(rhs.getPosition());
			}
		});
		Collections.sort(onField, new Comparator<MockPlayer>() {
			@Override
			public int compare(MockPlayer lhs, MockPlayer rhs) {
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0 && lhs.getTotalScore().compareTo(rhs.getTotalScore()) == 0) return lhs.getName().compareTo(rhs.getName());
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0) return -lhs.getTotalScore().compareTo(rhs.getTotalScore());
				return lhs.getPosition().compareTo(rhs.getPosition());
			}
		});
		Collections.sort(subs, new Comparator<MockPlayer>() {
			@Override
			public int compare(MockPlayer lhs, MockPlayer rhs) {
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0 && lhs.getTotalScore().compareTo(rhs.getTotalScore()) == 0) return lhs.getName().compareTo(rhs.getName());
				if(lhs.getPosition().compareTo(rhs.getPosition()) == 0) return -lhs.getTotalScore().compareTo(rhs.getTotalScore());
				return lhs.getPosition().compareTo(rhs.getPosition());
			}
		});
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
	
	public boolean onFieldIsLegal() {
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
	
	public static boolean isPartlyLegal(List<MockPlayer> roster, MockPlayer player, Integer financialStatus) {
		if(player.getPrice() > financialStatus) return false;
		List<MockPlayer> newRoster = new ArrayList<>();
		newRoster.addAll(roster);
		newRoster.add(player);
		if(newRoster.size() > 14) return false;
		if(User.getPosCount(newRoster, PlayerPosition.GOAL) > MAX_GOAL) return false;
		if(User.getPosCount(newRoster, PlayerPosition.DEFENCE) > MAX_DEFENCE) return false;
		if(User.getPosCount(newRoster, PlayerPosition.MIDFIELD) > MAX_MIDFIELD) return false;
		if(User.getPosCount(newRoster, PlayerPosition.FORWARD) > MAX_FORWARD) return false;
		return true;
	}

}
