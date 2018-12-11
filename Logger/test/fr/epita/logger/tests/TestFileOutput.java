package fr.epita.logger.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFileOutput {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("application.log");
		PrintWriter writer = new PrintWriter(file);
		Date date = new Date();
		String format = "yyyy-MM-dd HH:mm:ss,SSS";

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		writer.println(dateFormat.format(date) + " message example ");
		writer.flush();
		writer.close();
	}

}
