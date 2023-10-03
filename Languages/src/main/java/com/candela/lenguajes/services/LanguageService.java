package com.candela.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candela.lenguajes.models.LanguageModel;
import com.candela.lenguajes.repos.LanguageRepo;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepo languageRepo;
    
    public LanguageService(LanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }
    
    public List<LanguageModel> allLangs(){
    	return languageRepo.findAll();
    }
    
    public LanguageModel findLang(Long id) {
    	Optional<LanguageModel> lang = languageRepo.findById(id);
    	if(lang.isPresent() == true) {
    		return lang.get();
    	} else {
    		return null;
    	}
    }
    
    public LanguageModel createLang(LanguageModel lang) {
    	return languageRepo.save(lang);
    }
    
    public LanguageModel updateLang(Long id, LanguageModel lang) {
    	LanguageModel temporaryLang = findLang(id);
    	temporaryLang.setName(lang.getName());
    	temporaryLang.setCreator(lang.getCreator());
    	temporaryLang.setCurrentVersion(lang.getCurrentVersion());
    	return languageRepo.save(temporaryLang);
    }
    
    public void deleteLang(Long id) {
    	languageRepo.deleteById(id);
    }
}
