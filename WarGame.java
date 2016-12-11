public class WarGame
{

	private int battles;
	private int wars;
	private int warsDub;

	public WarGame(){
		this.battles = battles;
		this.wars = wars;
		this.warsDub = warsDouble;
	}

	public void play(){
		Player play = new Player();
		battles = 0;
		wars = 0;
		warsDub = 0;
		play.shuffle(play.getPlayer1Deck());
		play.shuffle(play.getPlayer2Deck());
		while(play.hasWon() == false){
			if(battles % 52 == 0 && battles > 0){
				play.shuffle(play.getPlayer1Deck());
				play.shuffle(play.getPlayer2Deck());
			}

			if(play.getPlayer1Deck().getFirst().getCardValue() == play.getPlayer2Deck().getFirst().getCardValue()){
				wars += play.war();
				if(play.war() == 2){
					warsDub++;
				}
			}else if(play.getPlayer1Deck().getFirst().getCardValue() > play.getPlayer2Deck().getFirst().getCardValue()){

				battles++;
				play.collect(play.getPlayer1Deck());
				play.collect(play.getPlayer2Deck());
				play.flip(play.getPlayer1Deck());
				play.flip(play.getPlayer2Deck());
				play.player1Wins();
			}
			else{
				battles++;
				play.collect(play.getPlayer1Deck());
				play.collect(play.getPlayer2Deck());
				play.flip(play.getPlayer1Deck());
				play.flip(play.getPlayer2Deck());
				play.player2Wins();

			}
		}
		play.getPlacedCards().clear();
		play.getPlayer1Deck().clear();
		play.getPlayer2Deck().clear();
	}

	public int getBattles(){
		return battles;
	}

	public int getWars(){
		return wars;
	}

	public int getWarsDouble(){
		return warsDub;
	}
}
