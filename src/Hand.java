
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
	
	public int identify() {
		int numVal = 0;
		
		// tests for straight flush
		boolean straightFlush = true;
		for(int i = 0; i < 4; i++) {
			if(hand[i].suit() != hand[i + 1].suit()) {
				straightFlush = false;
			} 
			if ((hand[i].pointValue() + 1) != hand[i + 1].pointValue()) {
				straightFlush = false;
			} 
		}
		if(straightFlush) {
			numVal = 9;
		}
		
		//Four of a kind   
		boolean fourOfAKind = false;
		int count = 0;
		for(int j = 0; j < 4; j++) {
			if(hand[j].pointValue() == hand[j + 1].pointValue()) {
				count++;
			}
		}
		if(count == 4) {
			fourOfAKind = true;
			numVal = 8;
		} 
		
		//full house 
		int count2 = 0; 
		for(int k = 0; k < 4; k++) {
			if(hand[k].pointValue() == hand[k + 1].pointValue()) {
				count2++;
			}
		}
		
		//flush
		boolean flush = true;
		for(int l = 0; l < 4; l++) {
			if(hand[l].suit() != hand[l + 1].suit()) {
				flush = false;
			}
		}
		if(flush) { 
			numVal = 6;
		}
		
		//straight
		boolean straight = true;
		for(int i = 0; i < 4; i++) { 
			if ((hand[i].pointValue() + 1) != hand[i + 1].pointValue()) {
				straight = false;
			} 
		}
		if(straight) {
			numVal = 5;
		}
		
		//three of a kind
		boolean threeOfAKind = false;
		int count3 = 0;
		for(int j = 0; j < 4; j++) {
			if(hand[j].pointValue() == hand[j + 1].pointValue()) {
				count3++;
			}
		}
		if(count3 == 3) {
			threeOfAKind = true;
			numVal = 4;
		} 
		
		//Two pair 
		
		//One pair
		boolean onePair = false;
		int count4 = 0;
		for(int j = 0; j < 4; j++) {
			if(hand[j].pointValue() == hand[j + 1].pointValue()) {
				count4++;
			}
		}
		if(count4 == 2) {
			onePair = true;
			numVal = 2;
		} 
	
		//High card
		if(numVal == 0) {
			numVal = 1;
		}
		
		
		return numVal;
	
	}
	
	public void sort() {
		
	}
	
	public String compare(Hand compHand) {
		return "yeet";
	}
}
