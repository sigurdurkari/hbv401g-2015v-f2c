package tests;

import org.junit.*;

import static org.junit.Assert.*;
import models.*;

import java.util.*;

public class MakePurchaseTest {
	
	private static Game testGame;
	
	@Before
	public void setUp() {
		testGame = BasicEntities.generateGame();
	}
	
	@After
	public void tearDown() {
		testGame = null;
	}
	
	@Test
	public void makePurchaseTest() {
		User user = testGame.getUsers().get(0);
		List<Player> in = testGame.getTeams().get(0).getPlayersByPosition(PlayerPosition.DEFENCE).subList(0, 3);
		List<Player> out = testGame.getUsers().get(0).getRoster().getPlayersByPosition(PlayerPosition.DEFENCE).subList(0, 3);
		
		user.makePurchase(in, out);
		
		for(Player p : in) {
			// Check if the players we bought are in the roster
			assertEquals(true, user.getRoster().contains(p));
		}
		for(Player p : out) {
			// Check if the players we sold are not in the roster
			assertEquals(false, user.getRoster().contains(p));
		}
		// Check if the roster is legal
		assertEquals(true, user.getRoster().isLegal());
	}
	
}