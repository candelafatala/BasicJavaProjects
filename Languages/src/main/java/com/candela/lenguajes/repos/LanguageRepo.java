package com.candela.lenguajes.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.candela.lenguajes.models.LanguageModel;

public interface LanguageRepo extends CrudRepository<LanguageModel, Long> {
	
	List<LanguageModel> findAll(); 
	
}
