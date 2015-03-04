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
		
		List<User> users = new ArrayList<>();
		User user1 = new User("Siggi", 0, Game.STARTING_CASH, new Roster());
		users.add(user1);
		
		Game testGame = new Game(users, teams);
		
		return testGame;
	}

}
