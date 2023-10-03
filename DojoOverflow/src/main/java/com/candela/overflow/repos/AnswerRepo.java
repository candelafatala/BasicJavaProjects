package com.candela.overflow.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.candela.overflow.models.Answer;
import com.candela.overflow.models.Question;

public interface AnswerRepo extends CrudRepository<Answer, Long> {
	
	List<Answer> findByQuestion(Question question);
}
