import java.util.LinkedList;
import java.util.Random;
public class WarCardDeck
{
private LinkedList<Card> deck;

	public WarCardDeck(){
		deck = new LinkedList<Card>();
		for(int i = 2; i <= 14; ++i){
			Card card = new Card(i);
			deck.add(card);
		}
		for(int i = 2; i <= 14; ++i){
			Card card = new Card(i);
			deck.add(card);
		}
		for(int i = 2; i <= 14; ++i){
			Card card = new Card(i);
			deck.add(card);
		}
		for(int i = 2; i <= 14; ++i){
			Card card = new Card(i);
			deck.add(card);
		}
	}

	public Card deal(){
		Random random = new Random();
		Card card = deck.get(random.nextInt(deck.size()));
		deck.remove(card);
		return card;
	}

}
