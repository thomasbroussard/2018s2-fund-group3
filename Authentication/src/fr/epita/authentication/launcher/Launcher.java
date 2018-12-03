package fr.epita.authentication.launcher;

import java.util.Scanner;

public class Launcher {

	// TODO remove those hard coded credentials
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "pwd";

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
		}

		scanner.close();

	}

	private static boolean authenticate(String userName, String password) {
		return USERNAME.equals(userName) && PASSWORD.equals(password);
	}

	private static String getAnswer(Scanner scanner, String question) {
		System.out.print(question);
		String userName = scanner.nextLine();
		return userName;
	}

}
