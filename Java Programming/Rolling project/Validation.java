public class Validation {
	
	public Validation(){}

	public static boolean isBlank(String userInput){

		// remove whitespaces and check if there are any other characters
		// false if not blank, true if blank
		boolean checkBlank = userInput.trim().length() > 0;
		
		if (userInput != null && checkBlank){
			return false;  // so syntax is close to human language -- "if isBlank is true, input is invalid"
		}
		else {
			String errorMessage = "Invalid input";  // improve error msg
			System.out.println(errorMessage);
			return true;
		}
	}

	public static boolean lengthWithinRange(String userInput, int minLength, int maxLength){

		if (userInput.length() >= minLength && userInput.length() <= maxLength) {
			return true;
		}
		else{
			String errorMessage = "Invalid input";  // improve error msg
			System.out.println(errorMessage);
			return false;
		}
	}
}