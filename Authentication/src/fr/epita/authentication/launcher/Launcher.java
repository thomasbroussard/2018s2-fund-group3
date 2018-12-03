package fr.epita.authentication.launcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Launcher {
	

	public static void main(String[] args) {
		System.out.println("Welcome to the application");
		System.out.println("Please, enter your credentials");
		Scanner scanner = new Scanner(System.in);

		String userName = getAnswer(scanner, "User name :");
		String password = getAnswer(scanner, "Password :");

		if (authenticate(userName, password)) {

			System.out.println("Welcome " + userName);
			boolean exit = false;
			do {
				System.out.println("Please choose one action");
				System.out.println("1. Create");
				System.out.println("2. Search");
				System.out.println("3. Exit");
				String answer = getAnswer(scanner, "Please input your choice (1|2|3|4)");
				switch (answer) {
				case "1":
					break;
				case "2":
					System.out.println("Sub Menu: enter your search keyword: ");
					//TODO program update and delete after displaying the list
					break;
				case "3":
					answer = getAnswer(scanner, "do you confirm you want to exit the application (y/N)?");

					exit = "y".equals(answer);

					break;
				default:
					break;
				}
			} while (!exit);
		}else {
			System.out.println("not authenticated, exiting");
		}

		scanner.close();

	}

	private static boolean authenticate(String userName, String password) {
		File file = new File("auth.txt");
		Scanner scanner;
		String user = null;
		String pwd = null;
		try {
			scanner = new Scanner(file);
			String nextLine = scanner.nextLine();
			String[] parts = nextLine.split("=");
			user  = parts[0];
			pwd = parts[1];
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return (userName.equals(user) && password.equals(pwd));
		
	}

	private static String getAnswer(Scanner scanner, String question) {
		System.out.print(question);
		String userName = scanner.nextLine();
		return userName;
	}

}
