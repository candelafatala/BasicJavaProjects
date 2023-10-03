package com.candela.overflow.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.candela.overflow.models.Tag;

public interface TagRepo extends CrudRepository<Tag, Long>{
	
	@Query(value="SELECT tags.* FROM tags_questions "
			+ "JOIN questions ON tags_questions.question_id = questions.id "
			+ "JOIN tags ON tags_questions.tag_id = tags.id "
			+ "WHERE questions.id = :questionID", nativeQuery=true)
	List<Tag> findByQuestion(Long questionID);
	
	Tag findBySubject(String subject);
}
