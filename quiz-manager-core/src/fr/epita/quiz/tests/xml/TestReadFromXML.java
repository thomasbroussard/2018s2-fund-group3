package fr.epita.quiz.tests.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestReadFromXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		
		Document doc = docBuilder.parse(new File("questions.xml")); 
		
		NodeList list = doc.getElementsByTagName("question");
		for (int i = 0; i < list.getLength(); i++) {
			Element currentQuestion = (Element) list.item(i);
			NodeList labelList = currentQuestion.getElementsByTagName("label");
			String order = currentQuestion.getAttribute("order");
			System.out.println(order +". " +labelList.item(0).getTextContent());
		}
		
	}
	
}
