
public class Hand {
	Card[] hand = new Card[5];
    int numVal = 0;
	
	public Hand(Deck d) {
		d.shuffle();
		for(int i = 0; i < 5; i++) {
			hand[i] = d.deal();
		}
	}
	
	public String displayHand() {
		sortByRank();
		String hand = "";
			for(int i = 0; i < this.hand.length; i++) {
				hand += this.hand[i] + "\n";
			}
		return hand;
	}
	
	public void sortByRank() {
        for (int i = 1; i < 5; ++i) { 
        	
            int key = hand[i].pointValue(); 
            Card sub = hand[i];
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && hand[j].pointValue() > key) { 
                hand[j + 1] = hand[j]; 
                j = j - 1; 
            } 
            hand[j + 1] = sub; 
        } 
	}
	
	public int getNumVal() {
		return numVal;
	}
	
	public int identify() {
		
		sortByRank();
		
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
			System.out.println("hand is a: Straight Flush");
		}
		
		//Four of a kind   
		
		boolean one, two;
		
		one = hand[0].pointValue() == hand[1].pointValue() &&
		           hand[1].pointValue() == hand[2].pointValue() &&
		           hand[2].pointValue() == hand[3].pointValue() ;


		      /* ------------------------------------------------------
		         Check for: lower ranked unmatched card 
			            + 4 cards of the same rank 
			 ------------------------------------------------------- */   
		two = hand[1].pointValue() == hand[2].pointValue() &&
				hand[2].pointValue() == hand[3].pointValue() &&
						hand[3].pointValue() == hand[4].pointValue() ;
		
		boolean fourOfAKind = ( one || two );
		if(fourOfAKind) {		
			numVal = 8;
			System.out.println("hand is a: Four of a Kind");
		} 
		
		
		//full house 
		boolean x, y;
		
		x = hand[0].pointValue() == hand[1].pointValue() &&
			hand[1].pointValue() == hand[2].pointValue() &&
			hand[3].pointValue() == hand[4].pointValue();

		      
		y = hand[0].rank() == hand[1].rank() &&
			hand[2].rank() == hand[3].rank() &&
			hand[3].rank() == hand[4].rank();
		
		boolean fullHouse = ( x || y);
		if(fullHouse) {
			numVal = 7;
			System.out.println("hand is a: Full House");
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
			System.out.println("hand is a: Flush");
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
			System.out.println("hand is a: Straight");
		}
		
		//three of a kind
		
		boolean eeny, meeny, miny;
		
		 eeny = hand[0].pointValue() == hand[1].pointValue() &&                  
		           hand[1].pointValue() == hand[2].pointValue() ;

		     
		 meeny = hand[1].pointValue() == hand[2].pointValue() &&
		           hand[2].pointValue() == hand[3].pointValue() ;

		     
		  miny = hand[2].pointValue() == hand[3].pointValue() &&
		           hand[3].pointValue() == hand[4].pointValue() ;

		
		
		boolean threeOfAKind = (eeny || meeny || miny);

		if(threeOfAKind && fullHouse == false && fourOfAKind == false) {
			threeOfAKind = true;
			numVal = 4;
			System.out.println("hand is a: Three of a Kind");
		} 
		
		//Two pair 
		boolean a1, a2, a3;
		
		a1 = hand[0].pointValue() == hand[1].pointValue() &&
		           hand[2].pointValue() == hand[3].pointValue() ;

		
		a2 = hand[0].pointValue() == hand[1].pointValue() &&
		           hand[3].pointValue() == hand[4].pointValue() ;

		      
		a3 = hand[1].pointValue() == hand[2].pointValue() &&
		         hand[3].pointValue() == hand[4].pointValue() ;
		
		boolean twoPair = ( a1 || a2 || a3 );
		if(twoPair && threeOfAKind == false && fullHouse == false && fourOfAKind == false) {
			numVal = 3;
			System.out.println("hand is a: Two Pair");
		}

		
		
		//One pair
		boolean q, w, e, r;
		q = hand[0].pointValue() == hand[1].pointValue() ;

	      
	    w = hand[1].pointValue() == hand[2].pointValue() ;

	      
	    e = hand[2].pointValue() == hand[3].pointValue() ;

	     
	    r = hand[3].pointValue() == hand[4].pointValue() ;
		
		boolean onePair = (q || w || e || r); 
		
		
		if(onePair && twoPair == false) {
			numVal = 2;
			System.out.println("hand is a: One Pair");
		} 
	
		//High card
		if(numVal == 0) {
			numVal = 1;
			System.out.println("hand is a: High Card");
		}
		
		return numVal;
	
	}
	
	public void sort() {
		
	}
	
	public boolean compare(Hand yourHand, Hand compHand) {
		boolean isGreaterThan;
		isGreaterThan = yourHand.getNumVal() > compHand.getNumVal();
		if(isGreaterThan) {
			System.out.println("Your hand beats the computer hand.");
		} else if(yourHand.getNumVal() == compHand.getNumVal())
			System.out.println("Your hand is the same as the computer hand.");
		else {
			System.out.println("The computer hand beat your hand.");
		}
		return isGreaterThan;
	}
}
