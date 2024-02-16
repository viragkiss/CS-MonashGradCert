// @author: Virag Kiss
// @version: 2
// @date: 4/4/2023
/*
Changes: all object methods made into class methods (static) so no need to create Input objects all the time
*/

import java.util.Scanner;

public class Input{
	
	public Input(){}

	public static char acceptCharInput(String message, int index){

		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		String str = scanner.next();
		char charInput = str.charAt(index);
		//System.out.println("Testing char input - the char entered is: "+charInput);
		return charInput;
	}

	public static double acceptDoubleInput(String message){

		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		double doubleInput = Double.parseDouble(scanner.nextLine());
		//System.out.println("Testing double input - the double entered is: "+doubleInput);
		return doubleInput;
	}

	public static int acceptIntegerInput(String message){

		Scanner scanner = new Scanner(System.in);
		int intInput = -1;
		boolean hasInt = false;

		System.out.println(message);
		if(scanner.hasNextInt()) {
    		intInput = Integer.parseInt(scanner.nextLine());
			hasInt = true;
		}
		else{
			System.out.println("Invalid input for credit points");
		}
		
		// better logic but not working
		/*do{
			System.out.println(message);
			if(scanner.hasNextInt()) {
				intInput = Integer.parseInt(scanner.nextLine());
				hasInt = true;
    		}
			else{
				System.out.println("Invalid response, please enter an integer: ");
			}
		} while ( !hasInt );*/

		//System.out.println("Testing int input - the int entered is: "+intInput);
		return intInput;
	}

	public static String acceptStringInput(String message){

		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		String stringInput = scanner.nextLine();
		//System.out.println("Testing string input - the string entered is: "+stringInput);
		return stringInput;
	}
}