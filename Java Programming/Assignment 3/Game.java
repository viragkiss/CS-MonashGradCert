/*	Virag Kiss
	Game class
	v.4
	24/4/2023
*/

// libraries
import java.lang.Math;
import java.util.ArrayList;

public class Game{

	// considered using the HashMap but opted for ArrayList because it's ordered and we only have a small list-small time complexity to search
	
	//CONSTANTS
	public static final char[] VALID_DIRECTIONS = {'N','W','S','E'}; // north west east south
	public static final char[] VALID_RESPONSES = {'Y','N'}; // yes no
	public static final int MIN_P = 0;
	public static final int MAX_P = 100;
	public static final String READ_FILE = "exits.txt";
	public static final String WRITE_FILE = "outcome.txt";
	
	private static int pCoin = 30;
	private static int pAlarm = 25;
	private static int pCloak = 15;
	private static int pCoal = 30;

	public void displayCurrentRoom(Room room){
		
		System.out.println("Maze probabilities:");
		room.display();
	}

	public static int getPCoin(){
		return Game.pCoin;
	}

	public static int getPAlarm(){
		return Game.pAlarm;
	}

	public static int getPCloak(){
		return Game.pCloak;
	}

	public static int getPCoal(){
		return Game.pCoal;
	}

	public static void setPCoin(int newCoin){
		Game.pCoin = newCoin;
	}

	public static void setPAlarm(int newAlarm){
		Game.pAlarm = newAlarm;
	}

	public static void setPCloak(int newCloak){
		Game.pCloak = newCloak;
	}

	public static void setPCoal(int newCoal){
		Game.pCoal = newCoal;
	}

	public void inputPlayerInfoOnce(Player player, int backJumps, int coins){

		String name;
		boolean isInputBlank, isInputWithinRange;

		do{
			name = Input.acceptString("Please enter your name. Name must be 3-12 characters long: ");
			isInputBlank = Validation.isBlank(name);
			isInputWithinRange = Validation.lengthWithinRange(name, 3, 12);
		} while( !isInputBlank || !isInputWithinRange);

		player.setName(name);
		player.setCoins(coins);
		player.setBackJumps(backJumps);

		System.out.println("Welcome to Javalice, "+player.getName()+"!");
		System.out.println("As a magic wielder, your goal is to find the exit portal and escape Javalice.");
		System.out.println("You have "+player.getCoins()+" coins and "+player.getBackJumps()+" back jumps available. Use them wisely to run away from the magic police!\n");
		System.out.println("Maze signs:\n|---| = closed      |   | = open      |exit| = exit\n");
	}

	public void generateExitProbability(Room room, String direction){
		
		int currentP, newP;
		Portal portal;

		portal = room.getPortal(direction);
		currentP = portal.getPExit();
		newP = this.calculateProbability(currentP);
		portal.setPExit(newP);
	}

	public void generatePoliceProbability(Room room, String direction){
		
		int currentP, newP;
		Portal portal;

		portal = room.getPortal(direction);
		currentP = portal.getPPolice();
		newP = this.calculateProbability(currentP);
		portal.setPPolice(newP);
	}

	public int calculateProbability(int currentP){
		
		int change, newP;

		if( Math.random() < 0.5 ) {
  			change = ((int)(Math.random() * ((5 - 1) + 1)) + 1)*(-1);
		}else{
			change = (int)(Math.random() * ((5 - 1) + 1)) + 1;
		}
		// test lines
		//double tmp = change / 100.0;
		//System.out.println("Change in probability is "+change+"%, which equals to: "+tmp);
		newP = currentP + change;
		if (newP <= MAX_P && newP >= MIN_P){
			return newP;
		}
        else if (newP > MAX_P){
			return MAX_P;
		}
		else{
			return MIN_P;
		}
	}

	// dynamic method to generate any item based on current probability of item as long as order in the array is kept the same
	public Item generateItem(){
		
		int[] pItems = {this.pCoin, this.pAlarm, this.pCloak, this.pCoal};
		int[] probabilities = new int[4];
		Item item;
		int sum = 0;

		// cumulatively add probabilities to create ranges
		for (int i=0; i<pItems.length; i++){
			sum += pItems[i];
			probabilities[i] = sum;
		}
		// generate a random number betwwen 0 and 100 and find its range
		int rnd = (int)(Math.random()*100);
		int index = 0;
		for (int j=0; j<probabilities.length; j++){
			if(rnd > probabilities[j]){
				index++;
			}
		}
		// based on the probability range the random falls in, create specific item
		switch(index){
			case(0):
				// generate Coin() with random amount between [15, 35]
				int amount = (int)(Math.random() * ((35 - 10) + 1)) + 10;
				item = new Coin("coin", pItems[0], amount);
				break;
			case(1):
				item = new Alarm("alarm", pItems[1], 3); // could pass alarm value as argument for future dev
				break;
			case(2):
				item = new Cloak("cloak", pItems[2]);
				break;
			case(3):
				item = new Item("coal", pItems[3]);
				break;
			default:
				System.out.println("Could not generate specific item in magic box.");
				item = new Item();
		}
		return item;
	}

	public void openMagicBox(Item item, Player player, Room room){
		
		System.out.println("Opening magic box...");
		
		if (item instanceof Coin) {
    		// add amount to player's coins
			Coin coins = (Coin)item;
			System.out.println("You found "+coins.getAmount()+" coins! Adding it to purse.");
			player.collectCoins(coins);
		}
		else if(item instanceof Alarm){
			// raise magic police probability in all directions by amount stored in the Alarm object
			Alarm alarm = (Alarm)item;
			System.out.println("You found a magic police alarm! Increasing the probability of a police encounter by 3% in ALL directions.\nRun for your life!");
			int amount = alarm.getAmount();
			int newP;
			for (Portal portal : room.getPortals()){
				newP = portal.getPPolice() + amount;
				portal.setPPolice(newP);
			}
			System.out.println("Updated maze probabilities:");
			room.display();
		}
		else if(item instanceof Cloak){
			// add cloak to inventory of player
			Cloak cloak = (Cloak)item;
			System.out.println("You found an invisibility cloak! This cloak will help you escape the magic police next time.\nAdding it to inventory");
			player.addToInventory(cloak);
		}
		else if(item.getId() == "coal"){
			System.out.println("You found coal. Unfortunately, it is useless to you. Better luck next time!");
		}
		else{
			System.out.println("Error in finding item inside magix box.");
		}
	}

	public char generateOptions(Player player){
		int cloaks = player.getSizeOfInventory();
		int coins = player.getCoins();
		int jumps = player.getBackJumps();
		char r;
		boolean isValid;
		
		ArrayList<Character> validChoices = new ArrayList<Character>();
		ArrayList<String> validMessages = new ArrayList<String>();

		if(cloaks > 0){
			validChoices.add('C');
			validMessages.add("Enter c to use your invisibility cloak and hide from the police");
		}
		if(coins > 0){
			validChoices.add('B');
			validMessages.add("Enter b to bribe the police");
		}
		if(jumps > 0){
			validChoices.add('J');
			validMessages.add("Enter j to jump back to the previous room");
		}

		char[] validCharChoices = new char[validChoices.size()];
		for (int i=0; i<validChoices.size(); i++){
			validCharChoices[i] = validChoices.get(i);
		}
				
		System.out.println("You encountered the magic police! You have "+coins+" coin(s), "+cloaks+" cloak(s), and "+jumps+" jump(s). What do you want to do?");
		for(String str : validMessages){
			System.out.println(str);
		}

		do{
			r = Input.acceptChar("Please respond now:");
			isValid = Validation.isValid(r, validCharChoices);
		}while(!isValid);

		return r;
	}

	public boolean policeEncounter(Player player, Room room, int round){
		
		int coins = player.getCoins();
		int jumps = player.getBackJumps();
		int cloaks = player.getSizeOfInventory();

		if( coins<1 && jumps<1 && cloaks<1 ){
			System.out.println("Sorry, you have no coins, invisibility cloaks or back jumps left and you landed in jail. Game over fam.");
			return false;
		}

		char response = this.generateOptions(player);

		if (response == 'C'){
			room.setIsPoliceDirectly(false);
			player.removeCloak();
			System.out.println("The magic police now can't see you. Huh, that was close...");
			return true;
		}
		else if(response == 'B'){
			int bribe = player.generatePoliceBribe();
			System.out.println("The police is requesting "+bribe+" coins.");

			if (bribe > coins){
				System.out.println("Oops, you don't have enough coins so you landed in jail.");
							
				if (round < 1){
					System.out.println("As you're in the first room, you cannot jump back.\nSorry fam, game over.");
					return false;
				}
				else if (jumps > 0){
					System.out.println("Good news, you can jump back instead.");
					return false;
				}
				else{
					System.out.println("Sorry, you landed in jail. Game over fam.");
					return false;
				}
			}
			else{
				System.out.println("Paying "+bribe+" coins to the police...");
				player.setCoins(coins - bribe);
				return true;
			}
		}
		else if(response == 'J'){
			if (round < 1){
				System.out.println("As you're in the first room, you cannot jump back.\nSorry fam, game over.");
				return false;
			}
			else{
				return false;
			}
		}
		else{
			System.out.print("Test-- police encounter choice did not work.");
			return true;
		}
	}

	public void magicBoxEncounter(Player player, Room room){
		Item item = this.generateItem();
		char r;
		boolean isValid;
		System.out.println("You found a magic box! Do you want to open it?");
		do{
			r = Input.acceptChar("Press y or n: ");
			isValid = Validation.isValid(r, VALID_RESPONSES);
		}while(!isValid);

		if(r == VALID_RESPONSES[0]){
			this.openMagicBox(item, player, room);
		}
		else{
			System.out.println("Afraid of the magic box? Maybe next time you will find courage.");
		}
	}

	public boolean allClosedEncounter(Player player, int round){
		if (round < 1){
			System.out.println("Oops! All portals are closed. As you're in the first room, you cannot jump back.");
			System.out.println("Sorry fam, game over.");
			return false;
		}
		else if (player.getBackJumps() > 0){
			System.out.println("Oops! All portals are closed. Good news, you can jump back.");
			return true;
		}
		else{
			System.out.println("Oops! All portals are closed. Sorry, you are stuck in this room forever. Game over fam.");
			return false;
		}
	}

/////////////////////////////////////// MAIN ////////////////////////////////////////////////
	public static void main(String[] args){

		Game game = new Game();
		Player player = new Player();
		Room room = new Room();
		boolean gameOver = false;
		boolean outcome = false;
		boolean checkAllClosed, checkPolice, checkMagicBox, checkPortalOpen, checkPortalExit;
		String currentDirection="";
		int round = 0;
		int coins, cloaks;

		game.inputPlayerInfoOnce(player, 3, 10);

		// make portals
		FileIO.readFile(room, READ_FILE);

		room.setIsMagicBox(); // a magic box can already be found in the first room
		room.setIsPoliceOnce(); // a police encounter is possible in the first room
		
		// game play
		do{
			// display game info
			System.out.println("=================================================== Round "+(round+1)+" ===================================================\n");
			game.displayCurrentRoom(room);
			System.out.println("Player info: "+player.display());
			
			checkAllClosed = Validation.allExitsClosed(room);
			checkPolice = room.getIsPolice();
			checkMagicBox = room.getIsMagicBox();

			// magic box is found
			if(checkMagicBox == true){
				game.magicBoxEncounter(player, room);
			}

			// police encounter
			if (checkPolice == true){
				boolean gameOn = game.policeEncounter(player, room, round);

				if ((gameOn == false) && (player.getBackJumps() > 0)){
					Input.acceptAny("Press Enter to confirm: ");
					player.jumpBack(room, currentDirection);
					continue;
				}
				else if (gameOn = false){
					gameOver = true;
					outcome = false;
					continue;
				}
			}
			
			// all exits are closed
			if (checkAllClosed == true){
				
				boolean gameOn = game.allClosedEncounter(player, round);
				if(gameOn==false){
					gameOver = true;
					outcome = false;
					continue;
				}
				else{
					Input.acceptAny("Press Enter to confirm: ");
					player.jumpBack(room, currentDirection);
					continue;
				}
			}
			
			// jump forward
			do{
				currentDirection = player.jumpForward(VALID_DIRECTIONS, room); // returns string of chosen direction
				checkPortalOpen = Validation.isPortalOpen(currentDirection, room); // checks if portal is open in that direction
			}while(!checkPortalOpen);

			checkPortalExit = Validation.isExitPortal(currentDirection, room);
			if(checkPortalExit == true){
				System.out.println("Congratulations, you found the exit!");
				gameOver = true;
				outcome = true;
				continue;
			}
			else{
				// "create" next room
				// room object is constantly reused - there's only 1 room at any point in the game
				room.setIsPolice(currentDirection); // decides if there is police in the next room based on probability at the time of choosing direction
				game.generateExitProbability(room, currentDirection); // set new probabilities and exits in given direction
				game.generatePoliceProbability(room, currentDirection);
				room.generateNewRoom(); // sets properties other than isPolice
			}

			round += 1;

		} while( !gameOver );

		FileIO.writeFile(WRITE_FILE, player, outcome);
	}
}
