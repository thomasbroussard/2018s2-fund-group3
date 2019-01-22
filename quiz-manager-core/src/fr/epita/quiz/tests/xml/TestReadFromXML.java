package fr.epita.quiz.tests.xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionXMLDAO;

public class TestReadFromXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder docBuilder = factory.newDocumentBuilder();
//		Document doc = docBuilder.parse(new File("questions.xml")); 
//		
//		
//		NodeList list = doc.getElementsByTagName("question");
//		for (int i = 0; i < list.getLength(); i++) {
//			Element currentQuestion = (Element) list.item(i);
//			NodeList labelList = currentQuestion.getElementsByTagName("label");
//			String order = currentQuestion.getAttribute("order");
//			System.out.println(order +". " +labelList.item(0).getTextContent());
//		}
		QuestionXMLDAO dao = new QuestionXMLDAO();
		List<Question> listQuestions = dao.getAllQuestions();
		for (Question question : listQuestions) {
			System.out.println("Question : " + question.getQuestion());
			System.out.println("Difficulty : " + question.getDifficulty());
		}
	}
	
}
