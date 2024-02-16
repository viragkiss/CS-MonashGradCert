import java.util.ArrayList;

public class Player{
	
	private String name;
	private int backJumps, coins;
	private ArrayList<Item> inventory; // only holds cloaks for now
 
	public Player(){
		this.name = "Unknown";
		this.backJumps = -1;
		this.coins = -1;
		this.inventory = new ArrayList<Item>();
	}

	public Player(String name, int backJumps, int coins, ArrayList<Item> inventory){
		this.name = name;
		this.backJumps = backJumps;
		this.coins = coins;
		this.inventory = inventory;
	}

	public String display(){
		String displayString = "Name: "+this.name +", Back jumps: " + this.backJumps + ", Coins: "
		+this.coins+", Invisibility cloaks: "+this.inventory.size();
		return displayString;
	}

	public String getName(){
		return this.name;
	}

	public int getBackJumps(){
		return this.backJumps;
	}

	public int getCoins(){
		return this.coins;
	}

	public ArrayList<Item> getInventory(){
		return this.inventory;
	}

	public void setName(String newName){
		this.name = newName;
	}

	public void setBackJumps(int newJumps){
		this.backJumps = newJumps;
	}

	public void setCoins(int newCoins){
		this.coins = newCoins;
	}

	public void setInventory(ArrayList<Item> newInventory){
		this.inventory = newInventory;
	}

	public String jumpForward(char[] validDirections, Room room){
		char userInput;
		String direction = "";
		boolean isValidDirection, isInputBlank;

		do{
			userInput = Input.acceptChar("Please choose your direction: N, W, E, S:");
			isValidDirection = Validation.isValid(userInput, validDirections);
		} while(!isValidDirection);

		// return chosen direction based on first letter
		for (Portal portal : room.getPortals()){
			if(portal.getDirection().charAt(0) == userInput){
				direction = portal.getDirection();
			}
		}
		//System.out.println("Test--- The chosen direction is: "+direction);
		return direction;
	}

	public void jumpBack(Room room, String direction){
		this.backJumps -= 1;
		room.setIsPolice(direction);
		room.generateNewRoom();
		//System.out.println("Test--- Player jumped back. New room generated.");
	}

	public void addToInventory(Item item){
		this.inventory.add(item);
	}

	public void removeCloak(){
		this.inventory.remove(0);
	}

	public int getSizeOfInventory(){
		return this.inventory.size();
	}

	public void collectCoins(Coin coin){
		int amount = coin.getAmount();
		this.coins += amount;
	}

	public int generatePoliceBribe(){
		double rnd = (Math.random() * ((1.5 - 0.5) + 0.1)) + 0.5;
		int bribe = (int)(this.coins * rnd);
		return bribe;
	}

	public void test(){

		//Create a Player object with the default constructor.
		System.out.println("////Create a Player object with the default constructor");
		Player p1 = new Player();
		System.out.println(p1.display());

		//Create a Player object with the non-default constructor with valid field values
		System.out.println("////Create a Player object with the non-default constructor with valid field values");
		ArrayList<Item> inventory = new ArrayList<Item>();
		inventory.add(new Item());
		Player p2 = new Player("Bob", 3, 10, inventory); // supposed to show 1 in inventory
		System.out.println(p2.display());
		//Create a Player object with the non-default constructor with invalid field values
		System.out.println("////Create a Player object with the non-default constructor with invalid field values");
		Player p22 = new Player("B", -1, -1, inventory); // supposed to show 1 in inventory
		System.out.println(p22.display());

		//Test getBackJumps()
		System.out.println("////Test getBackJumps()");
		System.out.println(p2.getBackJumps());

		//Test getCoins()
		System.out.println("////Test getCoins()");
		System.out.println(p2.getCoins());

		//Test getInventory()
		System.out.println("////Test getInventory()");
		System.out.println(p2.getInventory());

		//Test getName()
		System.out.println("////Test getName()");
		System.out.println(p2.getName());

		//Test getSizeOfInventory()
		System.out.println("////Test getSizeOfInventory()");
		System.out.println(p2.getSizeOfInventory());  // supposed to show 1

		//Test setBackJumps() with valid values
		System.out.println("/////Test setBackJumps() with valid values");
		p1.setBackJumps(3);
		System.out.println(p1.display());
		//Test setBackJumps() with invalid values 
		System.out.println("/////Test setBackJumps() with invalid values");
		p1.setBackJumps(-1);
		System.out.println(p1.display());

		//Test setCoins() with valid values 
		System.out.println("////Test setCoins() with valid values");
		p1.setCoins(10);
		System.out.println(p1.display());
		//Test setCoins() with invalid values
		System.out.println("////Test setCoins() with invalid values");
		p1.setCoins(-1);
		System.out.println(p1.display());

		//Test setInventory()
		System.out.println("////Test setInventory()");
		System.out.println(p1.display());
		inventory.add(new Item()); // supposed to show 2 in inventory
		p1.setInventory(inventory);
		System.out.println(p1.display());

		//Test setName() with valid values
		System.out.println("////Test setName() with valid values");
		p1.setName("Vee");
		System.out.println(p1.display());
		//Test setName() with invalid values // validity checked elsewhere in the program
		System.out.println("////Test setName() with invalid values");
		p1.setName("V");
		System.out.println(p1.display());
		
		//Test addToInventory()
		System.out.println("////Test addToInventory()");
		System.out.println(p1.display());
		p1.addToInventory(new Item()); // supposed to show 3 in inventory
		System.out.println(p1.display());

		//Test collectCoins()
		System.out.println("////Test collectCoins()");
		Coin c = new Coin("coin", 30, 15);
		Player p3 = new Player("Hugh", 3, 0, inventory);
		System.out.println(p3.display());
		p3.collectCoins(c);
		System.out.println(p3.display());
		
		//Test generatePoliceBribe()
		System.out.println("////Test generatePoliceBribe()");
		Player p4 = new Player("JJ", 0, 10, inventory);
		int b = p4.generatePoliceBribe();
		System.out.println("The bribe is: "+b);
		System.out.println(p4.display());

		//Test jumpBack() with invalid values
		System.out.println("////Test jumpBack() with invalid values");
		System.out.println(p3.display());
		Room room = new Room();
		String d = "Southeast";
		p3.jumpBack(room, d);
		System.out.println(p3.display());
		System.out.println(room.getIsPolice());
		room.display();

		//Test jumpForward() with invalid values
		System.out.println("////Test jumpForward() with invalid values");
		char[] valid = {'N','S'};
		System.out.println("Valid directions are: N, S");
		String s = p3.jumpForward(valid, room);
		System.out.println("Return string is :"+s);

		//Test removeCloak()
		System.out.println("////Test removeCloak()");
		System.out.println(p3.display());
		p3.removeCloak();
		System.out.println(p3.display()); // supposed to show 2
	}
}
