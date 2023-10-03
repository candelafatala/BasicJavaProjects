package com.candela.overflow.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.candela.overflow.models.Question;

public interface QuestionRepo extends CrudRepository<Question, Long>{
	
	@Query(value="SELECT questions.* FROM tags_questions "
			+ "JOIN questions ON tags_questions.question_id = questions.id "
			+ "JOIN tags ON tags_questions.tag_id = tags.id "
			+ "WHERE tags.id = :tagID", nativeQuery=true)
	List<Question> findByTag(Long tagID);
	
}
