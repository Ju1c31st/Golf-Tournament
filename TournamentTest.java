package comp125;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * Sample test class for class Tournament.
 * @author scott September 2016
 *
 */
public class TournamentTest {
	
	@Test(timeout=3000)
	public void testEnter() {
		int [] par = {3,4,5,4,5,3,4,3,5,3,4,5,4,3,4,5,4,3};
		int [] scores1 = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		int [] scores2 = {4,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		int [] scores3 = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,5};
		Tournament T = new Tournament(par);
		T.enter("Norman",  2, scores1);
		T.enter("Palmer",  4, scores2);
		T.enter("Scott",  1, scores3);
		ArrayList<Player> players = T.getPlayers();
		Player player1 = new Player("Norman", 2, scores1);
		Player player2 = new Player("Palmer", 4, scores2);
		Player player3 = new Player("Scott", 1, scores3);
		assertTrue(players.get(0).equals(player1));
		assertTrue(players.get(1).equals(player2));
		assertTrue(players.get(2).equals(player3));
	}
	
	@Test(timeout=3000)
	public void testWinningScore() {
		int [] par = {3,4,5,4,5,3,4,3,5,3,4,5,4,3,4,5,4,3};
		int [] scores1 = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		int [] scores2 = {4,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		int [] scores3 = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,5};
		Tournament T = new Tournament(par);
		T.enter("Norman",  2, scores1);
		T.enter("Palmer",  4, scores2);
		T.enter("Scott",  1, scores3);
		assertEquals(T.winningScore(), 65);
	}
	
	@Test(timeout=3000)
	public void testWinners() {
		int [] par = {3,4,5,4,5,3,4,3,5,3,4,5,4,3,4,5,4,3};
		int [] scores1 = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		int [] scores2 = {4,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		int [] scores3 = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,5};
		Tournament T = new Tournament(par);
		T.enter("Norman",  2, scores1);
		T.enter("Palmer",  4, scores2);
		T.enter("Scott",  1, scores3);
		ArrayList<String> winners = T.winners();
		assertTrue(winners.get(0).equals("Norman"));
	}
	
	@Test(timeout=3000)
	public void testAlphabeticSort() {
		int [] par = {3,4,5,4,5,3,4,3,5,3,4,5,4,3,4,5,4,3};
		int [] scores1 = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		int [] scores2 = {4,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		int [] scores3 = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,5};
		Tournament T = new Tournament(par);
		T.enter("Scott",  1, scores3);
		T.enter("Norman",  2, scores1);
		T.enter("Palmer",  4, scores2);
		T.alphabeticSort();
		ArrayList<Player> sortedPlayers = T.getPlayers();
		Player player1 = new Player("Norman", 2, scores1);
		Player player2 = new Player("Palmer", 4, scores2);
		Player player3 = new Player("Scott", 1, scores3);
		assertTrue(sortedPlayers.get(0).equals(player1));
		assertTrue(sortedPlayers.get(1).equals(player2));
		assertTrue(sortedPlayers.get(2).equals(player3));
	}
}
