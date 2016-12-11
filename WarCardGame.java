public class WarCardGame
{


	private int totalWars;
	private int totalWarsDouble;
	private int totalBattles;

	private double avgBattles;
	private double avgWars;
	private double avgWarsDouble;
	private double maxNumBattles;
	private double minNumBattles;
	private double maxNumWars;
	private double minNumWars;

	public WarCardGame(int games){
		double[] battlesArr = new double[games];
		double[] warsArr = new double[games];
		double[] warsDubArr = new double[games];
		totalWars = 0;
		totalWarsDouble = 0;
		totalBattles = 0;
		maxNumBattles = 0;
		maxNumWars = 0;
		for(int i = 0; i < games; ++i){
			Game game = new Game();
			game.play();
			battlesArr[i] = game.getBattles();
			warsArr[i] = game.getWars();
			warsDubArr[i] = game.getWarsDouble();
			if(battlesArr[i] >= maxNumBattles){ //initializes maxBattles and minBattles (minBattles included in order to make first value)
				minNumBattles = maxNumBattles;
				maxNumBattles = battlesArr[i];
			}
			if (battlesArr[i] <= minNumBattles){ //re declares minBattles to a lesser value
				minNumBattlesInGame = battlesArr[i];
			}
			if(warsArr[i] >= maxNumWars){
				minNumWars = maxNumWars;
				maxNumWars = warsArr[i];
			}
			if (warsArr[i] <= minNumWars){
				minNumWars = warsArr[i];
			}
			totalBattles += battlesArr[i];
			totalWars += warsArr[i];
			totalWarsDouble += warsDubArr[i];
		}
		compute(games, totalBattles, totalWars, totalWarsDub);
		report();
	}

	public void compute(int games, int battles, int wars, int warsDub){
		avgBattles = (double) battles / games;
		avgWars = (double) wars / games;
		avgWarsDouble = (double) warsDub / games;
	}

  public void report(){
  		System.out.println("Average Battles Per Game: " + avgBattles);
  		System.out.println("Average Wars Per Game: " + avgWars);
  		System.out.println("Average War Doubles Per Game: " + avgWarsDouble);
  		System.out.println("Maximum Number of Battles in a Game: " + maxNumBattles);
  		System.out.println("Minimum Number of Battles in a Game: " + minNumBattles);
  		System.out.println("Maximum Number of Wars in a Game: " + maxNumWars);
  		System.out.println("Minimum Number of Wars in a Game: " + minNumWars);

  	}

  	public static void main(String[] args){
  		int games = Integer.parseInt(args.length[0]);
  		Simulation simulate = new Simulation (games);
  	}

  }
