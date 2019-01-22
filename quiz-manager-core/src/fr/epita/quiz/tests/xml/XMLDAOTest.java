package fr.epita.quiz.tests.xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionXMLDAO;

public class XMLDAOTest {

	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		QuestionXMLDAO dao = new QuestionXMLDAO();
		List<Question> listQuestions = dao.getAllQuestions();
		for (Question question : listQuestions) {
			System.out.println("Question : " + question.getQuestion());
			System.out.println("Difficulty : " + question.getDifficulty());
		}
	}
}
