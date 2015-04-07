package models;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class User implements Comparable<User>{
	
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
	
	public static int getPosCount(List<MockPlayer> players, PlayerPosition pos) {
		int count = 0;
		for(MockPlayer p : players) {
			count += p.getPosition()==pos ? 1 : 0;
		}
		return count;
	}
	
	public static int priceOfPlayers(List<MockPlayer> players) {
		int price = 0;
		for(MockPlayer p : players) {
			price += p.getPrice();
		}
		return price;
	}
	
	public static boolean isBuyLegal(User user, List<MockPlayer> in, List<MockPlayer> out) {
		Roster roster = user.getRoster();
		
		int keeperCount = roster.getPositionCount(PlayerPosition.GOAL) + getPosCount(in, PlayerPosition.GOAL) - getPosCount(out, PlayerPosition.GOAL);
		int defCount = roster.getPositionCount(PlayerPosition.DEFENCE) + getPosCount(in, PlayerPosition.DEFENCE) - getPosCount(out, PlayerPosition.DEFENCE);
		int midCount = roster.getPositionCount(PlayerPosition.MIDFIELD) + getPosCount(in, PlayerPosition.MIDFIELD) - getPosCount(out, PlayerPosition.MIDFIELD);
		int forwardCount = roster.getPositionCount(PlayerPosition.FORWARD) + getPosCount(in, PlayerPosition.FORWARD) - getPosCount(out, PlayerPosition.FORWARD);
		
		if(in.size()!=out.size() || in.size()>3 || out.size()>3 || in.isEmpty() || out.isEmpty()) {
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
	
	public void makePurchase(List<MockPlayer> in, List<MockPlayer> out) {
		for(MockPlayer p : out) {
			roster.removePlayer(p);
		}
		for(MockPlayer p : in) {
			roster.addPlayer(p);
		}
		updateFinancialStatus(priceOfPlayers(in)-priceOfPlayers(out));
	}
	
	public int compareTo(User u){
		return (u.getUserScore()).compareTo(userScore);
	}
	
	public static void main(String[] args){
		List<User> users = new ArrayList<>();
		
		users.add(new User("Siggi", 0, Game.STARTING_CASH, new Roster("The Mighty Ducks")));
		users.add(new User("Guðjón", 23, Game.STARTING_CASH, new Roster("Hver er Asswraith?")));
		users.add(new User("Marelle", 12, Game.STARTING_CASH, new Roster("The Magnificent Players")));
		
		Collections.sort(users);
		
		System.out.println(users.get(0).getUserName());
		
		
		
	}


	
}
