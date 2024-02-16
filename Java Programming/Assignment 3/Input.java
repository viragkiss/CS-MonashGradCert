import java.util.Scanner;

public class Input{
	
	// method is accessible anywhere in the program
	// accepts char input only
	// for simplicity of game flow, this method performs a check and if the next line in scanner is longer than 1 character, if yes the user is asked to input until valid
	public static char acceptChar(String message){
		Scanner scanner = new Scanner(System.in);
		String str;
		boolean isInputBlank;
		do{
			System.out.println(message);
			str = scanner.nextLine().trim();
			isInputBlank = Validation.isBlank(str);
		}while(!isInputBlank);
		
		char charInput = str.toUpperCase().charAt(0);
		//System.out.println("Testing char input - the char entered is: "+charInput); // test print
		return charInput;
	}

	// accepts a String and returns the input
	public static String acceptString(String message){

		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		String stringInput = scanner.nextLine();
		//System.out.println("Testing string input - the string entered is: "+stringInput); // test print
		return stringInput;
	}

	// input method when the user has to input Enter to confirm a move
	// the user cannot choose and has to press Enter
	// if Enter is not pressed, the game will still move on because this method accepts anything as valid and nothing is returned
	public static void acceptAny(String message){
		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		String stringInput = scanner.nextLine();
		//System.out.println("Test--- Confirm input."); // test print
	}
}
