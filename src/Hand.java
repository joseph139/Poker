
public class Hand {
	Card[] hand = new Card[5];
	
	public Hand(Deck d) {
		d.shuffle();
		for(int i = 0; i < 5; i++) {
			hand[i] = d.deal();
		}
	}
	
	public String displayHand() {
		String hand = "";
			for(int i = 0; i < this.hand.length; i++) {
				hand += this.hand[i] + "\n";
			}
		return hand;
	}
	
	public String identify() {
		return "gay";
	}
	
	public String compare() {
		return "yeet";
	}
}
