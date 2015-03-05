package tests;

import java.util.*;
import models.*;

public class BasicEntities {
	
	public static Game generateGame() {
		List<Team> teams = new ArrayList<>();
		Team team1 = new Team("Liverpool");
		for(int i=0; i<20; i++) {
			team1.addPlayer(new Player("LiverpoolPlayer" + i, "Liverpool", Roster.positions[i%4], 100*(i%6 + 1)));
		}
		team1.addPlayer(new Player("Torres", "Liverpool", PlayerPosition.FORWARD, 100000000));
		teams.add(team1);
		Team team2 = new Team("Manchester United");
		for(int i=0; i<20; i++) {
			team2.addPlayer(new Player("UnitedPlayer" + i, "Manchester United", Roster.positions[(i+1)%4], 100*(i%7 + 1)));
		}
		teams.add(team2);
		Team team3 = new Team("Manchester Shitty");
		for(int i=0; i<20; i++) {
			team3.addPlayer(new Player("ShittyPlayer" + i, "Manchester Shitty", Roster.positions[(3*i+1)%4], 100*(i%3 + 3)));
		}
		teams.add(team3);
		
		List<Player> goalkeepers = new ArrayList<>();
		List<Player> defenders = new ArrayList<>();
		List<Player> midfielders = new ArrayList<>();
		List<Player> forwards = new ArrayList<>();
		for(Team team : teams) {
			goalkeepers.addAll(team.getPlayersByPosition(PlayerPosition.GOAL));
			defenders.addAll(team.getPlayersByPosition(PlayerPosition.DEFENCE));
			midfielders.addAll(team.getPlayersByPosition(PlayerPosition.MIDFIELD));
			forwards.addAll(team.getPlayersByPosition(PlayerPosition.FORWARD));
		}
		
		List<User> users = new ArrayList<>();
		User user1 = new User("Siggi", 0, Game.STARTING_CASH, new Roster("The Mighty Ducks"));
		for(int i=0; i<14; i++) {
			Player player = new Player();
			if(i<2) {
				player = goalkeepers.get((3*i+7)%goalkeepers.size());
			} else if(i<7) {
				player = defenders.get((3*i+7)%defenders.size());
			} else if(i<12) {
				player = midfielders.get((3*i+7)%midfielders.size());
			} else {
				player = forwards.get((3*i+7)%forwards.size());
			}
			user1.getRoster().addPlayer(player);
			user1.updateFinancialStatus(-player.getPrice());
		}
		users.add(user1);
		User user2 = new User("Guðjón", 0, Game.STARTING_CASH, new Roster("Hver er Asswraith?"));
		for(int i=0; i<14; i++) {
			Player player = new Player();
			if(i<1) {
				player = goalkeepers.get((4*i+5)%goalkeepers.size());
			} else if(i<4) {
				player = defenders.get((4*i+5)%defenders.size());
			} else if(i<11) {
				player = midfielders.get((4*i+5)%midfielders.size());
			} else {
				player = forwards.get((4*i+5)%forwards.size());
			}
			user2.getRoster().addPlayer(player);
			user2.updateFinancialStatus(-player.getPrice());
		}
		users.add(user2);
		
		
		Game testGame = new Game(users, teams);
		
		return testGame;
	}

}
