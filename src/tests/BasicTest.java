package tests;

import org.junit.*;
import static org.junit.Assert.*;

import models.*;
import java.util.*;

public class BasicTest {
	
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
	public void rosterTest() {
		for(User user : testGame.getUsers()) {
			assertEquals(true, user.getRoster().isLegal());
		}
	}
	
	@Test
	public void purchaseTest() {
		// No actual purchase
		assertEquals(true, User.isBuyLegal(testGame.getUsers().get(0), new ArrayList<Player>(), new ArrayList<Player>()));
		// Too many goalkeepers
		assertEquals(false, User.isBuyLegal(testGame.getUsers().get(0), testGame.getTeams().get(0).getPlayersByPosition(PlayerPosition.GOAL).subList(0, 3), testGame.getUsers().get(0).getRoster().getPlayersByPosition(PlayerPosition.DEFENCE).subList(0, 3)));
		// Too expensive players
		List<Player> in = new ArrayList<>();
		in.add(testGame.getTeams().get(0).getPlayers().get(testGame.getTeams().get(0).getPlayers().size()-1));
		assertEquals(false, User.isBuyLegal(testGame.getUsers().get(0), in, testGame.getUsers().get(0).getRoster().getPlayers().subList(6, 7)));
	}

	@Test
	public void test() {
		
	}
}
