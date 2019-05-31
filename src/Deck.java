
import java.util.*;



public class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>();

	public Deck(String[] ranks, String[] suits, int[] values) {
		for(int i = 0; i < ranks.length; i++) {
			for(int j = 0; j < suits.length; j++) { 
					this.cards.add(new Card(ranks[i], suits[j], values[i]));
				}
			}
	}
	
	public boolean isEmpty() {
		return cards.size() == 0;
	}

	public int size() {
		return cards.size();
	}

	public void shuffle() {
		 Card temp;
         for(int x = 1; x<= cards.size(); x++)
         {
             int ramd1 = (int)(Math.random() * cards.size() );
             int ramd2 = (int)(Math.random() * cards.size());
             temp = cards.get(ramd1);
             cards.set(ramd1, cards.get(ramd2));
             cards.set(ramd2, temp);
         }
		
		
		
		
		
		
		
		
		/* int k = 0;
		int size = this.cards.size();
		ArrayList<Card> shuffled = cards;
			for(int i = 0; i < size / 2; i++) {
				shuffled.add(k, cards.get(i));
				k += 2;
			}
			k = 1;
			for(int j = 26; j < size; j++) {
				shuffled.add(k, cards.get(j));
				k += 2;
			}
		cards = shuffled;
		*/
	}

	public Card deal() {
		int size = cards.size();
		Card last = this.cards.remove(cards.size() - 1);
		return last;
	}

	@Override
	public String toString() {
		String rtn = "size = " + cards.size() + "\nUndealt cards: \n";
		

		for (int k = cards.size() - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((cards.size() - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= cards.size(); k--) {
			rtn = rtn + cards.get(k);
			if (k != cards.size()) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
