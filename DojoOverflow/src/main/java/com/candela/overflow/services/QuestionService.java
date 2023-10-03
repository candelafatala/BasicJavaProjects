package com.candela.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.candela.overflow.models.Answer;
import com.candela.overflow.models.Question;
import com.candela.overflow.repos.AnswerRepo;
import com.candela.overflow.repos.QuestionRepo;

@Service
public class QuestionService {
	
	private final QuestionRepo qRepo;
	private final AnswerRepo aRepo;
	public QuestionService(QuestionRepo qRepo, AnswerRepo aRepo) {
		this.qRepo= qRepo;
		this.aRepo = aRepo;
	}
	
	public Question findQById(Long id) {
		return qRepo.findById(id).orElse(null);
	}
	public Answer findAById(Long id) {
		return aRepo.findById(id).orElse(null);
	}
	public List<Question> findAllQs(){
		return (List<Question>) qRepo.findAll();
	}
	
	public List<Answer> findAsByQuestion(Question question){
		return aRepo.findByQuestion(question);
	}
	public List<Question> findQsByTags(Long tagID){
		return qRepo.findByTag(tagID);
	}
	
	public Question addQuestion(Question question) {
		return qRepo.save(question);
	}
	public Answer addAnswer(Answer answer) {
		return aRepo.save(answer);
	}
	
	public void deleteQuestion(Long id) {
		qRepo.deleteById(id);
	}
	public void deleteAnswer(Long id) {
		aRepo.deleteById(id);
	}
}
