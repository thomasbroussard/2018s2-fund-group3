package fr.epita.bank.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(new File("test.properties")));
	
		System.out.println(properties.getProperty("jdbc.user"));
		System.out.println(properties.getProperty("jdbc.password"));
		System.out.println(properties.getProperty("jdbc.url"));
	}
	
}
