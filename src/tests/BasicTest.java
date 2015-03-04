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
		List<Player> in = new ArrayList<>();
		
		
	}

}
