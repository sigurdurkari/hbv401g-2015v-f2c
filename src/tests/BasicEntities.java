package tests;

import java.util.*;
import models.*;

public class BasicEntities {
	
	public static Game generateGame() {
		List<MockTeam> teams = new ArrayList<>();
		MockTeam team1 = new MockTeam("Liverpool");
		for(int i=0; i<20; i++) {
			team1.addPlayer(new MockPlayer("LiverpoolPlayer" + i, "Liverpool", Roster.positions[i%4], 100*(i%6 + 1)));
		}
		team1.addPlayer(new MockPlayer("Andy Carroll", "Liverpool", PlayerPosition.FORWARD, 50000000));
		teams.add(team1);
		
		MockTeam team2 = new MockTeam("Manchester United");
		for(int i=0; i<20; i++) {
			team2.addPlayer(new MockPlayer("UnitedPlayer" + i, "Manchester United", Roster.positions[(i+1)%4], 100*(i%7 + 1)));
		}
		teams.add(team2);
		
		MockTeam team3 = new MockTeam("Manchester Shitty");
		for(int i=0; i<20; i++) {
			team3.addPlayer(new MockPlayer("ShittyPlayer" + i, "Manchester Shitty", Roster.positions[(3*i+1)%4], 100*(i%3 + 3)));
		}
		teams.add(team3);
		
		MockTeam team4 = new MockTeam("Arsenal");
		for(int i=0; i<20; i++) {
			team4.addPlayer(new MockPlayer("ArsenalPlayer" + i, "Arsenal", Roster.positions[(3*i+2)%4], 100*(i%5 + 3)));
		}
		teams.add(team4);
		
		MockTeam team5 = new MockTeam("Tottenham");
		for(int i=0; i<20; i++) {
			team5.addPlayer(new MockPlayer("TottenhamPlayer" + i, "Tottenham", Roster.positions[(i+2)%4], 100*(i%3)));
		}
		teams.add(team5);
		
		MockTeam team6 = new MockTeam("Swansea");
		for(int i=0; i<20; i++) {
			team6.addPlayer(new MockPlayer("SwanseaPlayer" + i, "Swansea", Roster.positions[i%4], 100*(i%3 + 3)));
		}
		teams.add(team6);
		
		MockTeam team7 = new MockTeam("Newcastle");
		for(int i=0; i<20; i++) {
			team7.addPlayer(new MockPlayer("NewcastlePlayer" + i, "Newcastle", Roster.positions[(3*i+1)%4], 100*(i%5 + 2)));
		}
		teams.add(team7);
		
		MockTeam team8 = new MockTeam("Everton");
		for(int i=0; i<20; i++) {
			team8.addPlayer(new MockPlayer("EvertonPlayer" + i, "Everton", Roster.positions[(i+1)%4], 100*(i%6 + 1)));
		}
		teams.add(team8);
		
		MockTeam team9 = new MockTeam("Aston Villa");
		for(int i=0; i<20; i++) {
			team9.addPlayer(new MockPlayer("AstonPlayer" + i, "Aston Villa", Roster.positions[(2*i+1)%4], 100*(i%5 + 1)));
		}
		teams.add(team9);
		
		MockTeam team10 = new MockTeam("Southhampton");
		for(int i=0; i<20; i++) {
			team10.addPlayer(new MockPlayer("SouthhamptonPlayer" + i, "Southhampton", Roster.positions[i%4], 100*(i%3)));
		}
		teams.add(team10);
		
		List<MockPlayer> goalkeepers = new ArrayList<>();
		List<MockPlayer> defenders = new ArrayList<>();
		List<MockPlayer> midfielders = new ArrayList<>();
		List<MockPlayer> forwards = new ArrayList<>();
		for(MockTeam team : teams) {
			goalkeepers.addAll(team.getPlayersByPosition(PlayerPosition.GOAL));
			defenders.addAll(team.getPlayersByPosition(PlayerPosition.DEFENCE));
			midfielders.addAll(team.getPlayersByPosition(PlayerPosition.MIDFIELD));
			forwards.addAll(team.getPlayersByPosition(PlayerPosition.FORWARD));
		}
		
		List<User> users = new ArrayList<>();
		User user1 = new User("Siggi", 0, Game.STARTING_CASH, new Roster("The Mighty Ducks"));
		for(int i=0; i<14; i++) {
			MockPlayer player = new MockPlayer();
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
			MockPlayer player = new MockPlayer();
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
		
		User user3 = new User("Kristrún", 0, Game.STARTING_CASH, new Roster("Tímon"));
		for(int i=0; i<14; i++) {
			MockPlayer player = new MockPlayer();
			if(i<1) {
				player = goalkeepers.get((3*i+7)%goalkeepers.size());
			} else if(i<4) {
				player = defenders.get((3*i+7)%defenders.size());
			} else if(i<11) {
				player = midfielders.get((3*i+7)%midfielders.size());
			} else {
				player = forwards.get((3*i+7)%forwards.size());
			}
			user3.getRoster().addPlayer(player);
			user3.updateFinancialStatus(-player.getPrice());
		}
		users.add(user3);
		
		User user4 = new User("Marelle", 0, Game.STARTING_CASH, new Roster("The Magnificent Players"));
		for(int i=0; i<14; i++) {
			MockPlayer player = new MockPlayer();
			if(i<2) {
				player = goalkeepers.get((4*i+5)%goalkeepers.size());
			} else if(i<7) {
				player = defenders.get((4*i+5)%defenders.size());
			} else if(i<12) {
				player = midfielders.get((4*i+5)%midfielders.size());
			} else {
				player = forwards.get((4*i+5)%forwards.size());
			}
			user4.getRoster().addPlayer(player);
			user4.updateFinancialStatus(-player.getPrice());
		}
		users.add(user4);
		
		Game testGame = new Game(users, teams);
		
		return testGame;
	}

}
