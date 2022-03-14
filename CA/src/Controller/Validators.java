package Controller;

public class Validators {


	/*
	 * Validator for integers, to make sure only numeric characters are used.
	 * If the input matches the regex, the method returns true.
	 * */
public static boolean isNumeric(String str) {
		  return str.matches("-?\\d+(\\.\\d+)?");  // Code from https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
		  											// Using a regular expression to validate if the user input is a numeric value
		}
	/*
	 * Validator for Strings, to make sure only alphabetic characters are used.
	 * If the input matches the regex, the method returns true.
	 * */
public static boolean nameValidator(String name) {

	return name.matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?");

	
	
}
}
