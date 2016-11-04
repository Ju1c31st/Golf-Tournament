package comp125;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Sample test class for class Player.
 * @author scott September 2016
 *
 */
public class PlayerTest {
	
	@Test(timeout=3000)
	public void testEqualArrays() {
		int [] a = {2, 3, 4, 5, 6};
		int [] b = {2, 3, 4, 5, 6, 7};
		int [] c = {2, 3, 4, 5, 6};
		int [] d = {};
		int [] e = {};
		int [] f = {2, 3, 4, 6, 5};
		assertTrue(Player.equalArrays(a, c));
		assertFalse(Player.equalArrays(a, b));
		assertTrue(Player.equalArrays(d, e));
		assertFalse(Player.equalArrays(c, d));
		assertFalse(Player.equalArrays(c, f));
	}
	//need to add test where scores are different
	
	@Test(timeout=3000)
	public void testEquals() {
		int [] myScores = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		Player myPlayer = new Player("Norman", 2, myScores);
		Player otherPlayer = new Player("Palmer", 2, myScores);
		int [] otherScores = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,5};
		Player thirdPlayer = new Player("Scott", 1, otherScores);
		Player fourthPlayer = new Player("Norman", 2, otherScores);
		assertTrue(myPlayer.equals(myPlayer));
		assertFalse(myPlayer.equals(otherPlayer));
		assertFalse(myPlayer.equals(thirdPlayer));
		assertFalse(myPlayer.equals(fourthPlayer));
	}
	
	@Test(timeout=3000)
	public void testComment() {
		int [] par = {3,4,5,4,5,3,4,3,5,3,4,5,4,3,4,5,4,3};
		int [] scores = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		assertTrue(Player.comment(scores[0], par[0]).equals("par"));
		assertTrue(Player.comment(scores[2], par[2]).equals("eagle!!"));
		assertTrue(Player.comment(scores[3], par[3]).equals("bogey"));
	}
	
	@Test(timeout=3000)
	public void testTotalScore() {
		int [] myScores = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		Player myPlayer = new Player("Norman", 2, myScores);
		assertEquals(myPlayer.totalScore(), 65);
	}
	
	
}
