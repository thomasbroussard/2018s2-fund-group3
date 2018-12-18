package fr.epita.quiz.datamodel;

import java.util.List;

public class Question {

	private String question; 
	private List<String> topics;	 
	private Integer difficulty;
	
	
	
	public Question(String question, List<String> topics, Integer difficulty) {
		this.question = question;
		this.topics = topics;
		this.difficulty = difficulty;
	}
	
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getTopics() {
		return topics;
	}
	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	
	
}
