package com.candela.lenguajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.candela.lenguajes.models.LanguageModel;
import com.candela.lenguajes.services.LanguageService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService languageService;
    
	public LanguageController(LanguageService languageService) {
		this.languageService= languageService;
	}
	
	@GetMapping("/")
	public String raiz() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String homePage(Model model, @ModelAttribute("lang") LanguageModel lang) {
		List<LanguageModel> langs = languageService.allLangs();
		model.addAttribute("langs", langs);
		return "/languages/homepage.jsp";
	}
	
	@PostMapping("/languages")
	public String newLang(@Valid @ModelAttribute("lang") LanguageModel lang, BindingResult result) {
		if(result.hasErrors() == true) {
			return "/languages/homepage.jsp";
		} else {
			languageService.createLang(lang);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String showLang(@PathVariable("id") Long id, Model model) {
		LanguageModel lang = languageService.findLang(id);
		if(lang == null) {
			return "redirect:/languages";
		}
		model.addAttribute("lang", lang);
		return "/languages/show.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String showEditLang(@PathVariable("id") Long id, Model model) {
		LanguageModel lang = languageService.findLang(id);
		if(lang == null) {
			return "redirect:/languages";
		}
		model.addAttribute("lang", lang);
		return "/languages/edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String editLang(@PathVariable("id") Long id, @Valid @ModelAttribute("lang") LanguageModel lang, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/edit.jsp";
		} else {
			languageService.updateLang(id, lang);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/{id}")
	public String deleteLang(@PathVariable("id") Long id, HttpSession session) {
		languageService.deleteLang(id);
		return "redirect:/languages";
	}
}
