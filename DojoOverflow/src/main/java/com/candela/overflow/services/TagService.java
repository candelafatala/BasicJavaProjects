package com.candela.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.candela.overflow.models.Tag;
import com.candela.overflow.repos.TagRepo;

@Service
public class TagService {
	
	private final TagRepo tRepo;
	public TagService(TagRepo tRepo) {
		this.tRepo = tRepo;
	}
	
	public Tag findTagById(Long id) {
		return tRepo.findById(id).orElse(null);
	}
	public List<Tag> findTagsByQuestion(Long questionID){
		return tRepo.findByQuestion(questionID);
	}
	public Tag findTagBySubject(String subject) {
		return tRepo.findBySubject(subject);
	}
	
	public Tag addTag(Tag tag) {
		return tRepo.save(tag);
	}
	
	public void deleteTag(Long id) {
		tRepo.deleteById(id);
	}

}
