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
		boolean win;
		
		Scanner console = new Scanner(System.in);
		System.out.println("How much would you like to bet? Your bet cannot go above " + money);
		System.out.println();
		int bet = console.nextInt();
		if(bet > 100) {
			throw new IllegalArgumentException("Bet cannot go over 100");
		}
		System.out.println();
		System.out.println("bet: " + bet);
		System.out.println();
		Hand playerHand = new Hand(d);
		System.out.println(playerHand.displayHand());
		System.out.print("Your ");
		playerHand.identify();
		System.out.println();
		Hand computerHand = new Hand(d);
		System.out.println(computerHand.displayHand());
		System.out.print("Computer ");
		computerHand.identify();
		System.out.println();
		win = playerHand.compare(playerHand, computerHand);
		System.out.println();
		money = returnBet(bet, money, win );
		System.out.println("You have: $" + money);
	}
	
	public static int returnBet(int bet, int money, boolean win) {
		if(win) {
			money += (bet * 2);
		} else {
			money -= bet;
		}
		return money;
		
	}
}
