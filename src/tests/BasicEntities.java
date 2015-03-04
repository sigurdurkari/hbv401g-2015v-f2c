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
		teams.add(team1);
		Team team2 = new Team("Manchester United");
		for(int i=0; i<20; i++) {
			team2.addPlayer(new Player("UnitedPlayer" + i, "Manchester United", Roster.positions[(i+1)%4], 100*(i%7 + 1)));
		}
		teams.add(team2);
		
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
		User user1 = new User("Siggi", 0, Game.STARTING_CASH, new Roster());
		for(int i=0; i<14; i++) {
			if(i<2) {
				user1.getRoster().addPlayer(goalkeepers.get((3*i+7)%goalkeepers.size()));
			} else if(i<7) {
				user1.getRoster().addPlayer(defenders.get((3*i+7)%defenders.size()));
			} else if(i<12) {
				user1.getRoster().addPlayer(midfielders.get((3*i+7)%midfielders.size()));
			} else {
				user1.getRoster().addPlayer(forwards.get((3*i+7)%forwards.size()));
			}
		}
		users.add(user1);
		
		Game testGame = new Game(users, teams);
		
		return testGame;
	}

}
