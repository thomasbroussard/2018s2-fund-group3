package fr.epita.logger.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		String format = "yyyy-MM-dd HH:mm:ss,SSS";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		System.out.println(dateFormat.format(date));
		

	}

}
