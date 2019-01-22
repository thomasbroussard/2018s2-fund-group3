package fr.epita.quiz.tests.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class TestWriteToXML {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//parsing file
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fact.newDocumentBuilder(); // create builder to parse the xml file
		Document doc = builder.parse(new File("questions.xml")); // parse xml file with builder and store it in doc object

		Element newQuestion = doc.createElement("question"); // new element creation
		newQuestion.setAttribute("order", "3");
		Element rootElement = doc.getDocumentElement();
		rootElement.appendChild(newQuestion); // adding the element as a child of a given element (here the root element)
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(); // creating a transformer to push the modifications
		transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.transform(new DOMSource(doc), new StreamResult("questions.xml")); // pushing the new value for the xml file

		
	}
}
