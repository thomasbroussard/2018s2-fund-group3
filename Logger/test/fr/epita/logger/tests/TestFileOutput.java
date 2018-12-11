package fr.epita.logger.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.epita.logger.Logger;

public class TestFileOutput {

	public static void main(String[] args) {
		Logger.logMessage("message example");
		Logger.logMessage("message example1");
		Logger.logMessage("message example2");

		
		
//		File file = new File("application.log");
//		PrintWriter writer = new PrintWriter(file);
//		logMessage(writer, "message example");
//		logMessage(writer, "message example1");
//		logMessage(writer, "message example2");
//		writer.close();
	}

	private static void logMessage(PrintWriter writer, String message) {
		Date date = new Date();
		String format = "yyyy-MM-dd_HH:mm:ss,SSS";

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		writer.println(dateFormat.format(date) + " " + message);
		writer.flush();
	}

}
