import java.util.Scanner;

public class Poker {

	public static void main (String[] args) {
		// make a Deck object and shuffle it
		String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};
		String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
				"Ten", "Jack", "Queen", "King", "Ace"};
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		Deck d = new Deck(ranks, suits, values);
		d.shuffle();
		
		int money = 100;
		
		Scanner console = new Scanner(System.in);
		System.out.println("How much would you like to bet? Your bet cannot go above " + money);
		int bet = console.nextInt();
		System.out.println("bet: " + bet);
		
		
		Hand playerHand = new Hand(d);
		System.out.println(playerHand.displayHand());
		Hand computerHand = new Hand(d);
		System.out.println(computerHand.displayHand());
		
		
	 // Will make Hand object for player and one Hand object for "computer"
	
	}
}
