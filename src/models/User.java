package models;

import java.util.List;
import java.util.ArrayList;

public class User {
	
	private String userName;
	private Integer userScore;
	private Integer financialStatus;
	private Roster roster;
	
	public User() {}

	public User(String userName, Integer userScore, Integer financialStatus, Roster roster) {
		this.userName = userName;
		this.userScore = userScore;
		this.financialStatus = financialStatus;
		this.roster = roster;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Roster getRoster() {
		return roster;
	}

	public void setRoster(Roster roster) {
		this.roster = roster;
	}
	
	public void updateFinancialStatus(int diff) {
		setFinancialStatus(getFinancialStatus() + diff);
	}
	
	public static int getPosCount(List<Player> players, PlayerPosition pos) {
		int count = 0;
		for(Player p : players) {
			count += p.getPosition()==pos ? 1 : 0;
		}
		return count;
	}
	
	public static int priceOfPlayers(List<Player> players) {
		int price = 0;
		for(Player p : players) {
			price += p.getPrice();
		}
		return price;
	}
	
	public static boolean isBuyLegal(User user, List<Player> in, List<Player> out) {
		Roster roster = user.getRoster();
		
		int keeperCount = roster.getPositionCount(PlayerPosition.GOAL) + getPosCount(in, PlayerPosition.GOAL) - getPosCount(out, PlayerPosition.GOAL);
		int defCount = roster.getPositionCount(PlayerPosition.DEFENCE) + getPosCount(in, PlayerPosition.DEFENCE) - getPosCount(out, PlayerPosition.DEFENCE);
		int midCount = roster.getPositionCount(PlayerPosition.MIDFIELD) + getPosCount(in, PlayerPosition.MIDFIELD) - getPosCount(out, PlayerPosition.MIDFIELD);
		int forwardCount = roster.getPositionCount(PlayerPosition.FORWARD) + getPosCount(in, PlayerPosition.FORWARD) - getPosCount(out, PlayerPosition.FORWARD);
		
		if(in.size()!=out.size() || in.size()>3 || out.size()>3) {
			return false;
		}
		if(keeperCount < Roster.MIN_GOAL || keeperCount > Roster.MAX_GOAL) {
			return false;
		}
		if(defCount < Roster.MIN_DEFENCE || defCount > Roster.MAX_DEFENCE) {
			return false;
		}
		if(midCount < Roster.MIN_MIDFIELD || midCount > Roster.MAX_MIDFIELD) {
			return false;
		}
		if(forwardCount < Roster.MIN_FORWARD || forwardCount > Roster.MAX_FORWARD) {
			return false;
		}
		if(priceOfPlayers(in)-priceOfPlayers(out) > user.getFinancialStatus()) {
			return false;
		}
		return true;
	}
	
	public void makePurchase(List<Player> in, List<Player> out) {
		for(Player p : out) {
			roster.removePlayer(p);
		}
		for(Player p : in) {
			roster.addPlayer(p);
		}
	}
	
}
