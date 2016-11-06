package comp125;

import java.util.ArrayList;

/**
 * Class to store the players in a golf tournament.
 * Several methods are incomplete.
 * Part of your task for Assign 2 is to complete them,
 * and answer Questions T1, T2 and T3.
 * @author Scott McCallum, September 2016
 * Completed by:
 * 44908415, Jonah Lee Skinner
 */


public class Tournament {

	private int [] par; // stores par for each hole in the golf course.
	private ArrayList<Player> players; // stores the list of players.

	public static final int NUMHOLES = 18;  // constant.

	/**
	 * Set par.
	 * @param thePar
	 */
	public void setPar(int [] thePar) {
		for (int i = 0; i < par.length; i++)
			par[i] = thePar[i];
	}

	/**
	 * Constructor with one parameter.
	 * @param thePar
	 */
	public Tournament(int [] thePar) {
		par = new int[NUMHOLES];
		setPar(thePar);
		players = new ArrayList<Player>();
	}

	public int [] getPar() {
		return par;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Enter a player with given name and handicap into the tournament.
	 * @param aName
	 * @param aHandicap
	 */
	public void enter(String aName, int aHandicap) {
		Player newPlayer = new Player(aName, aHandicap);
		players.add(newPlayer);

		//Done
	}

	/**
	 * Enter a player with given name, handicap and scores into tournament.
	 * @param aname
	 * @param aHandicap
	 * @param someScores
	 */
	public void enter(String aName, int aHandicap, int [] someScores) {
		Player newPlayer = new Player(aName, aHandicap, someScores);
		players.add(newPlayer);

		//Done
	}

	/**
	 * Simulate playing a round of golf for all the players
	 * in the tournament.
	 * Call method play(..) of class Player.
	 */
	public void playRound() {
		Player pPlayers; //playing Players
		for(int i=0; i<players.size(); i++){
			pPlayers = players.get(i);
			pPlayers.play(getPar());
		}
		// Supply this code!
	}

	/**
	 * Display list of players, each with his or her total score.
	 */
	public void showPlayers() {
		Player thePlayer;
		for (int i = 0; i < players.size(); i++) {
			thePlayer = players.get(i);
			System.out.printf("%-15s", thePlayer.getName());
			System.out.printf("%5d", thePlayer.totalScore());
			System.out.println();
		}
	}

	/*
	 * Assume as precondition that the list of players is not empty.
	 * Returns the winning score, that is, the lowest total score.
	 * @return winning score
	 */
	public int winningScore() {
		Player thePlayer = players.get(0);
		int result = thePlayer.totalScore(); 
		for(int i=0; i<players.size(); i++){
			int p = players.get(i).totalScore(); 
			if(p<result) {
				result = players.get(i).totalScore();
			}
		}
		return result;
		// Supply this code!
	}


	/**
	 * Returns the list of winners, that is, the names of those players
	 * with the lowest total score.
	 * The winners' names should be stored in the same order as they occur
	 * in the tournament list.
	 * If there are no players, return empty list.
	 * @return list of winners' names
	 */
	public ArrayList<String> winners() {
		ArrayList<String> result = new ArrayList<String>();
		int winningScore = winningScore(); //Calculates winning score.
		for(Player player : players) {
			if(player.totalScore() == winningScore){ 
				result.add(player.getName());//adds those with the winning score.
			}
		}
		return result;
		// Supply this code!
	}

	/**
	 * Auxiliary method to insert players[i] into the sorted region
	 * players[0..i-1].
	 * You may choose to implement this method.
	 * (This method itself will not be directly tested.)
	 * @param i
	 */
	public void insertIntoSortedRegion(int i) {
		if (players == null || i < 0 || i >= players.size())
			return ;
		// Supply this code if you wish.
	}

	/**
	 * Sorts the list of players alphabetically by name.
	 * Adapt **insertion sort algorithm**.
	 * You can assume that no two players have the same name.
	 * Question T1. Adapting insertion sort for this method
	 * could yield efficiencies relative to some other approaches
	 * for some important special cases.
	 * Do you agree and if so why? Write about 6 to 10 lines.
	 */
	/*
	 * T1: 
	 * I agree that insertionSort for this method could yield efficiencies relative to 
	 * some other approaches for some important special cases. 
	 * worst case: runs O(n^2) case time; insertionSort's worst case scenario is when 	
	 * the data is wildly random and or even in opposite order.this is because there are more	
	 * loop executions for n-1 times for an array of n elements where the first is 0 and last is n-1. 
	 * the method would execute 1+2+...+(n-1) times at most. This sum would be n(n-1)/2 which would 	
	 * imply O(n^2).
	 * for small lists (best case): it can run in O(n) time; insertionSort's operation time is 
	 * reduced when the array is partially sorted or already sorted. InsertionSort's Efficiency is 	
	 * relative to the special cases it is involved in sorting.
	 * 
	 * 
	 */
	public void alphabeticSort() {
		ArrayList<String> players = new ArrayList<String>();
//		Player players;
		int i, j;
		String pointer;
		for(j=0; j<players.size(); j++){
			pointer = players.get(j);
			i = j - 1;
			while(i >= 0){
//				if(pointer.compareTo(players)){


				}

			}
		}

		// Supply this code!


	/**
	 * Sorts the first n elements of the
	 * list of players alphabetically by name. Use recursion.
	 * Adapt recursive insertion sort algorithm.
	 * You can assume that no two players have the same name.
	 * You can also assume that 0 <= n <= players.size().
	 */
	public void alphabeticSortRec(int n) {

		// Supply this code!
	}

	/**
	 * Assume as precondition that the list of players has been
	 * sorted alphabetically by name.
	 * Returns the total score of the player whose name is passed in.
	 * If player is not in tournament, return -1.
	 * Adapt binary search algorithm.
	 * Question T2. Adapting binary search for this method could yield
	 * efficiencies relative to some other approaches.
	 * Do you agree and if so why? Write about 6 to 10 lines.
	 * @return total score of given player.
	 */
	/*T2:
	 * I agree Binary search is affected by different situations for example. 
	 * worst case: O(logn); this is when n/2^k where k gives the number of times the array	
	 * is divided in half or the recursive calls to binarySearch.
	 * average case: O(logn);
	 * best case: O(1); Binary search is one of the fastest algorithms for searching and its 	
	 * because it doesnt look at each and every element individually during its search. rather 	
	 * it makes a comparison every time the array is divided in half. so begnning with n items 	
	 * would result in n/2, n/4. So i agree that Binary search is affected by other approaches.
	 */
	public int findScore(String aName) {
//		if(!Tournament())
			return 0;  // Modify this code appropriately!
	}

	/**
	 * Returns ranking of players with winners coming first, etc.
	 * Equally ranked players should be listed in the same
	 * order as they occur in the tournament list.
	 * Adapt selection sort algorithm.
	 * Question T3. Adapting selection sort for this method could yield
	 * efficiencies relative to some other approaches for some
	 * important special cases. Do you agree and if so why?
	 * Write about 6 to 10 lines.
	 * @return ranking of players
	 */
	/*
	 * T3:
	 * I disagree because SelectionSort has O(n^2) operations regardless 
	 * of the type of data, and special case scenarios whether they be sorted, 
	 * partially sorted or wildly out of order. The reason the efficiency doesn't change
	 * is because in selectionSort the for loop executes n-1 times, so for example, it invokes 
	 * the methods getIndexOfSmallest and swap n-1 times each. During the n-1 call to getIndexOfSmallest, 
	 * last = n-1 and first has a range from 0 to n-2. Every time getIndexOfsmallest is invoked, its 
	 * loop executes in last - first times. for example: the loop executes 
	 * (n-1) + (n-2) + ...+ 1
	 * times.The sum of this n(n-1)/2 and the operations of the loop are O(1). 
	 * 
	 * So, i disagree to the fact that selectionSort's efficiency varies relative to certain situations because 
	 * SelectionSort sorts in any scenario at O(n^2) operations regardless of the data involved. 
	 */
	public ArrayList<Player> ranking() {
		ArrayList<Player> result = new ArrayList<Player>();

		// Supply this code!
		return result;
	}

	/**
	 * Carry out simple test of Tournament class.
	 * Add a few lines to test methods findScore and ranking.
	 */

	public static void main(String[] args) {
		System.out.println("Welcome to the golf tournament program.");
		int [] par = {3,4,5,4,5,3,4,3,5,3,4,5,4,3,4,5,4,3};
		Tournament T = new Tournament(par);
		T.enter("Norman", 2);
		T.enter("Scott", 4);
		T.enter("Day", 1);
		T.playRound();
		T.showPlayers();
		System.out.println("Winning score is " + T.winningScore());
		System.out.println("The winners are:");
		ArrayList<String> winners = T.winners();
		for (int i = 0; i < winners.size(); i++)
			System.out.println(winners.get(i));
		T.alphabeticSort();
		T.showPlayers();
		T.findScore("Scott");
		// Add a few lines to test methods findScore and ranking.
	}

}
