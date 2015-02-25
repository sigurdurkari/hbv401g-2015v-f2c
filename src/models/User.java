package models;

import java.util.List;
import java.util.ArrayList;

public class User {
	
	private Integer userScore;
	private Integer financialStatus;
	private String rosterName;
	
	public User() {}

	public User(Integer userScore, Integer financialStatus, String rosterName) {
		this.userScore = userScore;
		this.financialStatus = financialStatus;
		this.rosterName = rosterName;
	}

	public Integer getUserScore() {
		return userScore;
	}

	public void setUserScore(Integer userScore) {
		this.userScore = userScore;
	}

	public Integer getFinancialStatus() {
		return financialStatus;
	}

	public void setFinancialStatus(Integer financialStatus) {
		this.financialStatus = financialStatus;
	}

	public String getRosterName() {
		return rosterName;
	}

	public void setRosterName(String rosterName) {
		this.rosterName = rosterName;
	}
	
	public void updateFinancialStatus(int diff) {
		setFinancialStatus(getFinancialStatus() + diff);
	}
	
	public static int getPosCount(ArrayList<Player> players, PlayerPosition pos) {
		int count = 0;
		for(Player p : players) {
			count += p.getPosition()==pos ? 1 : 0;
		}
		return count;
	}
	
	public static int priceOfPlayers(ArrayList<Player> players) {
		int price = 0;
		for(Player p : players) {
			price += p.getPrice();
		}
		return price;
	}
	
	public boolean isBuyLegal(Roster roster, ArrayList<Player> in, ArrayList<Player> out) {
		if(in.size()!=out.size() || in.size()>3 || out.size()>3) {
			return false;
		}
		if(roster.getPositionCount(PlayerPosition.GOAL) + getPosCount(in, PlayerPosition.GOAL) - getPosCount(out, PlayerPosition.GOAL) < roster.MIN_GOAL) {
			return false;
		}
		if(roster.getPositionCount(PlayerPosition.DEFENCE) + getPosCount(in, PlayerPosition.DEFENCE) - getPosCount(out, PlayerPosition.DEFENCE) < roster.MIN_DEFENCE) {
			return false;
		}
		if(roster.getPositionCount(PlayerPosition.MIDFIELD) + getPosCount(in, PlayerPosition.MIDFIELD) - getPosCount(out, PlayerPosition.MIDFIELD) < roster.MIN_MIDFIELD) {
			return false;
		}
		if(roster.getPositionCount(PlayerPosition.FORWARD) + getPosCount(in, PlayerPosition.FORWARD) - getPosCount(out, PlayerPosition.FORWARD) < roster.MIN_FORWARD) {
			return false;
		}
		if(roster.getPositionCount(PlayerPosition.DEFENCE) + roster.getPositionCount(PlayerPosition.MIDFIELD) + getPosCount(in, PlayerPosition.DEFENCE) + getPosCount(in, PlayerPosition.MIDFIELD) - getPosCount(out, PlayerPosition.DEFENCE) - getPosCount(out, PlayerPosition.MIDFIELD) < roster.MIN_DEF_AND_MID) {
			return false;
		}
		if(priceOfPlayers(in)-priceOfPlayers(out) > financialStatus) {
			return false;
		}
		return true;
	}
	
}
