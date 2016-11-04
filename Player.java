package comp125;

import java.util.Random;

import com.sun.xml.internal.bind.v2.runtime.Name;

/**
 * Class to store family name, handicap and scores
 * for a golf player.
 * Several methods are incomplete. 
 * Part of your task for Assign 2 is to complete them,
 * and answer Question P1.
 * @author Scott McCallum, September 2016
 * Completed by: 
 */

public class Player {
	// attributes of player
	private String name;  // family name
	private int handicap;  // a golfing term (the number of strokes
	// which player is likely to make
	// above course par)
	private int [] scores; // scores for all holes in the course

	// Random generator belongs to class as a whole, 
	// so it is designated static.
	private static Random randomGenerator = new Random();

	// Returns a random variation from par for a given hole.
	// Question P1. Suppose that handicap = 18.
	// What are the minimum and maximum values that method variation()
	// can return?
	private int variation() {
		int randomNumber = randomGenerator.nextInt(90);
		return (randomNumber + handicap)/18 - 2;
	}

	public static final int NUMHOLES = 18;  // NUMHOLES is constant.

	/**
	 * Set name.
	 * @param aName
	 */
	public void setName(String aName) {
		name = aName;
	}

	/**
	 * Set handicap.
	 * @param aHandicap
	 */
	public void setHandicap(int aHandicap) { 
		handicap = aHandicap;
	}

	/**
	 * Set scores.
	 * @param someScores
	 */
	public void setScores(int [] someScores) {
		for (int i = 0; i < scores.length; i++)
			scores[i] = someScores[i];
	}

	/**
	 * Default constructor.
	 */
	public Player() {
		setName("Smith");
		setHandicap(0);
		scores = new int[NUMHOLES];
	}

	/**
	 * Constructor with two parameters.
	 */
	public Player(String aName, int aHandicap) {
		setName(aName);
		setHandicap(aHandicap);
		scores = new int[NUMHOLES];
	}
	/**
	 * Constructor with three parameters.
	 */
	public Player(String aName, int aHandicap, 
			int [] someScores) {
		setName(aName);
		setHandicap(aHandicap);
		scores = new int[NUMHOLES];
		setScores(someScores);
	}

	public String getName() {
		return name;
	}

	public int getHandicap() {
		return handicap;
	}

	public int [] getScores() {
		return scores;
	}

	/**
	 * Return true if the two arrays a and b have exactly the same elements
	 * in the same order, false otherwise.
	 * @param a
	 * @param b
	 * @return true if the two arrays a and b have exactly the same elements
	 * in the same order, false otherwise.
	 */
	public static boolean equalArrays(int [] a, int [] b) {
		if(a.length != b.length){
			return false;
		}else{
			int i = 0;
			while(i < a.length){
				if (a[i] != b[i]){
					return false;
				}
				i++;
			}
		}
		return true;
	}

	/**
	 * Return true if this player has exactly the same
	 * attributes as other player, false otherwise.
	 * 
	 * Call String method equals and Player method equalArrays.
	 * @param other
	 * @return true if this player has exactly the same attributes
	 * as other player, false otherwise.
	 * 
	 * 
	 */
	public boolean equals(Player other){
		int check = 0;
		if(name.equals(other.name) == true){ //Nested if statements which will increase the count of check.
			check++;
			
			if(this.handicap == other.handicap){//needs to compare Integers
				check++;
		
				if (equalArrays(this.scores, other.scores) == true){
					check++;
				}
			}
		}
		if(check == 3){ //if check = 3 ie. all the attributes are the same
			return true;
		}else{ 
			return false;
		}// Modify this code appropriately! 
	}


	/**
	 * Return appropriate comment for given score and par for hole.
	 * You can assume that score is not less than 4 below par for hole.
	 * For example, if score is 4 below par, return "condor!!!!",
	 * if score is 3 below par, return "albatross!!!",
	 * if score is 2 below par, return "eagle!!", etc.
	 * See Assign 2 description for full list of comments.
	 * @param score
	 * @param parForHole
	 * @return appropriate comment for given score and par for hole.
	 */
	public static String comment(int score, int parForHole) {
		
		return "Comment needed!"; // Replace by a suitable switch stmt.
	}

	/**
	 * Display the player's name and scores.
	 * For each score, provide an appropriate comment.
	 * @param par
	 */
	public void showScores(int [] par) {
		System.out.println("Scores for " + name);
		int score, parForHole;
		for (int i = 1; i <= scores.length; i++) {
			score = scores[i-1];
			System.out.print(i + "   " + score + "   ");
			parForHole = par[i-1];
			System.out.println(comment(score, parForHole));
		}
	}

	/**
	 * Return total score for player.
	 * @return total score for this player.
	 */
	public int totalScore() {
		int total = 0;
		/*
		 * 
		 */
		// Complete this code!
		return total;
	}

	/** 
	 * Return score for first n holes for player. Use recursion.
	 * You can assume that 0 <= n <= NUMHOLES.
	 * @param n
	 * @return score for first n holes for this player.
	 */
	public int totalScoreRec(int n) {
		return 0; // Modify this code appropriately!
	}

	/**
	 * Simulate round of golf for this player.
	 * For each hole, the score is obtained by adding
	 * variation() to par for the hole.
	 * @param par
	 */
	public void play(int [] par) {
		// Supply this code!
	}

	/*
	 * Carry out simple test of Player class.
	 * Add a couple of lines to test method equals. 
	 */

	public static void main(String [] args) {
		int [] par = {3,4,5,4,5,3,4,3,5,3,4,5,4,3,4,5,4,3};
		int [] myScores = {3,4,3,5,3,4,4,3,5,3,3,4,3,4,3,4,3,4};
		Player myPlayer = new Player("Norman", 2, myScores);
		myPlayer.showScores(par);
		System.out.println("Total score is " + myPlayer.totalScore());
		Player player1 = new Player("Ogilvy", 6);
		player1.play(par);
		player1.showScores(par);
		System.out.println("Total score is " + player1.totalScore());
		Player player2 = new Player("Scott", 2);
		player2.play(par);
		player2.showScores(par);
		System.out.println("Total score is " + player2.totalScore());
		// Add a couple of lines to test method equals.
	}
}
