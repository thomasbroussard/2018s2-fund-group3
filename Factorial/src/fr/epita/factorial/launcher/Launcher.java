package fr.epita.factorial.launcher;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		System.out.println("Enter a number (integer) :");
		int inputfromString = Integer.valueOf(scanner.nextLine());
		int result1 = calculateFactorialIterative(inputfromString);
		int result2 = calculateFactorialIterativeUsingFor(inputfromString);
		int result3 = calculateFactorialRecursive(inputfromString);
		System.out.println("iterative : factorial of " + inputfromString + " is equal to " + result1);
		System.out.println("recursive : factorial of " + inputfromString + " is equal to " + result3);
		System.out.println("iterative (for) : factorial of " + inputfromString + " is equal to " + result2);
		
		scanner.close();

	}
	
	public static int calculateFactorialIterative(int input) {
		int result = 1;
		
		while (input > 1 ) {
			result = result * input; 
			input = input - 1;
		}
	
		return result;
	}
	
	public static int calculateFactorialRecursive (int input) {
		if (input <= 1) {
			return input;
		}else {
			return calculateFactorialRecursive(input - 1) * input;
		}
	}

	public static int calculateFactorialIterativeUsingFor(int input) {
		int result = 1;
		for (int i = input; i > 0; i--) {
			result = result * i;
		}
		return result;
	}
	
}
