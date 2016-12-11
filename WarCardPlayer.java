import java.util.LinkedList;
import java.util.Random;
public class Player
{

	private LinkedList<Card> player1Deck = new LinkedList<Card>();
	private LinkedList<Card> player2Deck = new LinkedList<Card>();
	private LinkedList<Card> placedCards = new LinkedList<Card>();

	public Player(){ //constructor
		Deck deck = new Deck();
		for(int i = 0; i < 26; ++i){ //shuffling cards
			player1Deck.add(deck.deal());
		}
		for(int i = 0; i < 26; ++i){
			player2Deck.add(deck.deal());
		}
	}

	public LinkedList<Card> getPlayer1Deck(){
		return player1Deck;
	}

	public LinkedList<Card> getPlayer2Deck(){
		return player2Deck;
	}

	public LinkedList<Card> getPlacedCards(){
		return placedCards;
	}

	public void collect(LinkedList<Card> deck){
		placedCards.add(deck.getFirst());
	}

	public void flip(LinkedList<Card> deck){
		deck.removeFirst();
	}

	public void player1Wins(){
		player1Deck.addAll(placedCards);
		placedCards.clear();
	}

	public void player2Wins(){
		player2Deck.addAll(placedCards);
		placedCards.clear();
	}

	public boolean hasWon(){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean hasOneCard(){
		if(player1Deck.size() == 1 || player2Deck.size() == 1){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean hasThreeCards(){
		if(player1Deck.size() == 3 || player2Deck.size() == 3){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean hasTwoCards(){
		if(player1Deck.size() == 2 || player2Deck.size() == 2){
			return true;
		}
		else{
			return false;
		}
	}

	public int war(){

		do{
			while(player1Deck.getFirst().getCardValue() == player2Deck.getFirst().getCardValue() && hasTwoCards() && hasOneCard() == false){ // a person has 2 cards left
					collect(player1Deck);
					collect(player2Deck);
					flip(player1Deck);
					flip(player2Deck);

					warCounter++;
					break;
			}
			while(player1Deck.getFirst().getCardValue() == player2Deck.getFirst().getCardValue() && hasThreeCards() && hasOneCard() == false){ //a person has 3 cards left

				for(int i = 0; i < 2; ++i){
					collect(player1Deck);
					flip(player1Deck);
					collect(player2Deck);
					flip(player2Deck);
					if(hasOneCard()){
						break;
					}

				}
				warCounter++;
			}
			while(player1Deck.getFirst().getCardValue() == player2Deck.getFirst().getCardValue() && hasTwoCards() == false && hasThreeCards() == false && hasOneCard() == false){ // more than 3 cards left

				for(int i = 0; i < 3; ++i){
					collect(player1Deck);
					flip(player1Deck);
					collect(player2Deck);
					flip(player2Deck);
					if(hasOneCard()){
						break;
					}

				}
				warCounter++;
		}
		}while(player1Deck.getFirst().getCardValue() == player2Deck.getFirst().getCardValue() && hasOneCard() == false);
		while(player1Deck.getFirst().getCardValue() == player2Deck.getFirst().getCardValue() && hasOneCard()){ // takes in account if on the last flip, and someone has 1 card left, to keep flipping the other persons deck until they dont match

			if(player2Deck.size() == 1){
				for(int i = 0; i < 3; ++i){
					collect(player1Deck);
					flip(player1Deck);

				}
			}else if(player1Deck.size() == 1){
				for(int i = 0; i < 3; ++i){
					collect(player2Deck);
					flip(player2Deck);

				}
			}
		}
		if(player1Deck.getFirst().getCardValue() > player2Deck.getFirst().getCardValue()){
			player1Wins();
		}
		else if(player2Deck.getFirst().getCardValue() > player1Deck.getFirst().getCardValue()){
			player2Wins();
		}
		return warCounter;
	}

	 public void shuffle(LinkedList<Card> list){
		 Random random = new Random();
		 LinkedList<Card> shuffleDeck = new LinkedList<Card>();
		 for(int i = 0; i < list.size(); ++i){
			 shuffleDeck.add(list.remove(random.nextInt(list.size())));
		 }
		 list.addAll(shuffleDeck);
	 }
}
