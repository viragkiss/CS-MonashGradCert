import java.util.ArrayList;
import java.lang.Math;

public class Room{

	private ArrayList<Portal> portals;
	private boolean isPolice, isMagicBox;

	public Room(){
		this.portals = new ArrayList<Portal>();
		this.isPolice = false;
		this.isMagicBox = false;
	}

	public Room(ArrayList<Portal> portals, boolean isPolice, boolean isMagicBox){
		this.portals = portals;
		this.isPolice = isPolice;
		this.isMagicBox = isMagicBox;
	}

	public void display(){
		for (Portal portal : this.portals){
            System.out.println(portal.display());
        }
		// visualization
		char d;
        String north = "----";
        String[] west = new String[4];
        String[] east = new String[4];
        String south = "----";

        for (Portal portal : this.portals){
            d = portal.getDirection().charAt(0);
            switch(d){
            	case 'N':
            		if(portal.getIsExit() == true){
            			north = "exit";
            		}
            		else if(portal.getIsOpen() == true){
            			north = "    ";
            		}
            		else{
            			north = "----";
            		}
            		break;
            	case 'W':
            		if(portal.getIsExit() == true){
						west[0]="e";
						west[1]="x";
						west[2]="i";
						west[3]="t";
            		}
            		else if(portal.getIsOpen() == true){
						for(int j=0; j<4; j++){
							west[j]=" ";
						}
            		}
            		else{
						for(int j=0; j<4; j++){
							west[j]="|";
						}
            		}
            		break;
            	case 'E':
            		if(portal.getIsExit() == true){
						east[0]="e";
						east[1]="x";
						east[2]="i";
						east[3]="t";
            		}
            		else if(portal.getIsOpen() == true){
						for(int j=0; j<4; j++){
							east[j]=" ";
						}
            		}
            		else{
						for(int j=0; j<4; j++){
							east[j]="|";
						}
            		}
            		break;
            	case 'S':
            		if(portal.getIsExit() == true){
            			south = "exit";
            		}
            		else if(portal.getIsOpen() == true){
            			south = "    ";
            		}
            		else{
            			south = "----";
            		}
            		break;
            	default:
					for(int j=0; j<4; j++){
						west[j]="|";
					}
					for(int j=0; j<4; j++){
						east[j]="|";
					}
            }
        }

        System.out.println("      "+north);
        System.out.println("    |      |");
        System.out.println("    |      |");
        System.out.println(" ---        ---");
        for (int i=0; i<4; i++){
        	System.out.println(west[i]+"              "+east[i]);
        }
        System.out.println(" ---        ---");
        System.out.println("    |      |");
        System.out.println("    |      |");
        System.out.println("      "+south);
	}

	public void addPortal(Portal portal){
		this.portals.add(portal);
	}

	public ArrayList<Portal> getPortals(){
		return this.portals;
	}
	// get a certain portal with field of certain direction
	public Portal getPortal(String direction){
		for (Portal portal : this.getPortals()){
            if(direction == portal.getDirection()){
            	return portal;
            }
        }
        System.out.println("No portal found in this direction.");
		return new Portal();
	}

	public boolean getIsPolice(){
		return this.isPolice;
	}

	public boolean getIsMagicBox(){
		return this.isMagicBox;
	}

	public void setPortals(ArrayList<Portal> portals){
		this.portals = portals;
	}
	
	// sets whether police is present in the room based on chosen direction
	public void setIsPolice(String direction){
		int pPolice = 1; // variable to assign current pPolice value
		for (Portal portal : this.portals){
            if(direction == portal.getDirection()){
            	pPolice = portal.getPPolice();
            }
        }
        //System.out.println("Current probability of police: "+pPolice+" %"); // test print
		this.isPolice = ( Math.random() < (pPolice / 100.0) ) ? true : false;
	}

	public void setIsMagicBox(){
		this.isMagicBox = ( Math.random() < 0.5 ) ? true : false;
	}

	public void setIsPoliceDirectly(boolean isPolice){
		this.isPolice = isPolice;
	}

	// calculates whether police is present in the first room at the start of the game
	// randomly selects a probability and sets isPolice based on that probability
	public void setIsPoliceOnce(){
		int n = this.portals.size();
		int[] policeProbabilities = new int[n];
		int i = 0;
		
		for (Portal portal : this.portals){
			policeProbabilities[i] = portal.getPPolice();
		}

		int randomIndex = (int)(Math.random() * (((n-1) - 0) + 1)) + 0;
		try{
			this.isPolice = ( Math.random() < policeProbabilities[randomIndex] ) ? true : false;
		}
		catch(Exception e){
			System.out.println("Could not generate presence of police at start of game.");
		}
	}
	
	// generate new exits based on current probabilities
	public void generateNewRoom(){
		for (Portal portal : this.portals){
            portal.setIsOpen();
            portal.setIsExit();
        }
        this.setIsMagicBox();
        //System.out.println("Test--- New room generated.");
	}
}
