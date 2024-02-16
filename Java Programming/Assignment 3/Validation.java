public class Validation {
	
	// checks if a user input string is blank
	// returns true if not blank, false if blank
	public static boolean isBlank(String userInput){

		boolean checkBlank = userInput.trim().length() > 0;
		
		if (userInput != null && checkBlank){
			return true;  
		}
		else {
			String errorMessage = "Invalid input. Input should not be blank.";
			System.out.println(errorMessage);
			return false;
		}
	}

	// checks if a user input string is within a given range, upper and lower boundaries inclusive
	// method is dynamic, range may be specified during compilation or runtime
	// returns true if input is valid (within range, inclusive) and false if invalid
	public static boolean lengthWithinRange(String userInput, int minLength, int maxLength){

		if (userInput.length() >= minLength && userInput.length() <= maxLength) {
			return true;
		}
		else{
			String errorMessage = "Invalid input. Input should be at least "+minLength+" and at most "+maxLength+" characters.";
			System.out.println(errorMessage);
			return false;
		}
	}

	// checks if a character input is within a set of valid inputs for the game, in this case 4 directions {n,w,e,s} and 2 responses {y,n}
	// other types of input are not required in Javalice, but method can be easily modified to fit other input types eg String
	// returns true if input is accepted (and can be used by other methods of the game) and false if not accepted
	public static boolean isValid(char userInput, char[] validInputs){
		
		for (int i=0; i<validInputs.length; i++){
			if (validInputs[i]==userInput){
				return true;
			}
		}
		return false;
	}

	// checks for the special case of all exits being closed in a room the player arrived in
	// receives a Room object, which has an ArrayList<Portal> field that can be accessed with a get method
	// each Portal has a get method of isOpen, which returns true if open and false if closed
	// returns true if no open exit is found, and false as soon as it finds at least one open exit
	// complexity O(n) in worst case, n=number of items in ArrayList
	public static boolean allExitsClosed(Room room){
		
		for (Portal portal : room.getPortals()){
            if (portal.getIsOpen()==true){
            	return false;
            }
        }
        //System.out.println("Test--- Oops! All exits are closed."); // test print
        return true;
	}

	// checks if a given portal in a room is open or closed
	// receives a Room object and searches its ArrayList<Portal> type field based on a direction specified by the user
	// returns true if portal is open, and false if closed and prints an error message in latter case informing the user to choose another portal
	// performs with O(n) complexity in worst case, n=number of items in ArrayList
	public static boolean isPortalOpen(String direction, Room room){
		
		for (Portal portal : room.getPortals()){
			if ( portal.getDirection() == direction ){
				if ( portal.getIsOpen() == true){
					return true;
            	}
            	else{
            		System.out.println("Portal closed in this direction. Please choose another direction.");
            		return false;
            	}
            }
        }
        System.out.println("Test--- No open portal matching direction."); // prints if direction is invalid (doesn't exist as a field of any portal)
        return false; // default condition if by any chance the directions is invalid // should not occur
	}

	// works the same as the above method
	public static boolean isExitPortal(String direction, Room room){
		
		for (Portal portal : room.getPortals()){
            if ( portal.getDirection() == direction ){
            	if (portal.getIsExit() == true){
            		return true;
            	}
            	else{
            		//System.out.println("Test--- This portal is not an exit.");
            		return false;
            	}
            }
        }
        System.out.println("Test--- No open portal matching direction.");
        return false;
	}
}
