package com.candela.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.candela.overflow.models.Answer;
import com.candela.overflow.models.Question;
import com.candela.overflow.models.Tag;
import com.candela.overflow.services.QuestionService;
import com.candela.overflow.services.TagService;

import jakarta.validation.Valid;

@Controller
public class QuestionsController {
	
	private final QuestionService qServ;
	private final TagService tServ;
	public QuestionsController(QuestionService qServ, TagService tServ) {
		this.qServ = qServ;
		this.tServ = tServ;
	}
	
	@GetMapping("")
	public String root() {
		return "redirect:/questions";
	}
	
	@GetMapping("/questions")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("questions", qServ.findAllQs());
		return "questions.jsp";
	}
	
	//añadir pregunta con tags
	
	@GetMapping("/questions/new")
	public String newQ(@ModelAttribute("newQuestion") Question newQuestion) {
		return "newQ.jsp";
	}
	
	@PostMapping("/questions/new")
	public String newQPost(@Valid @ModelAttribute("newQuestion") Question newQuestion, BindingResult result, 
			@RequestParam("tagsParam") String tagsParam, Model viewModel) {
		if(result.hasErrors()) {
			return "newQ.jsp";
		}
		
		List<Tag> tagList = new ArrayList<>(); //lista con las tags que agregaremos a la nueva pregunta
		String[] tagArray = tagsParam.split(","); //array con cada tag ingresada en el reqparam
		
		if(tagArray.length > 3) {
			viewModel.addAttribute("error", "You can only add up to 3 tags");
			return "newQ.jsp";
		}
		
		for(String tag : tagArray) {
			String oneTag = tag.trim().toLowerCase(); //pasamos cada etiqueta del array a minusculas y sin espacios
			Tag existTag = tServ.findTagBySubject(oneTag); //vemos si esa etiqueta ya existe en la base de datos
			
			//agregamos las etiquetas a la lista de tags
			if(existTag == null) {
				Tag newTag = new Tag();
				newTag.setSubject(oneTag);
				tagList.add(newTag);
			} else {
				tagList.add(existTag);
			}
		}
		
		//guardamos tags y pregunta en base de datos
		for(Tag eachTag : tagList) {
			tServ.addTag(eachTag);
		}
		newQuestion.setTags(tagList);
		qServ.addQuestion(newQuestion);
		
		
		return "redirect:/questions";
	}
	
	//mostrar detalles de pregunta + respuestas
	
	@GetMapping("/questions/{qID}")
	public String showQ(@PathVariable("qID") Long qID, Model viewModel, @ModelAttribute("userAnswer") Answer userAnswer) {
		
		Question question = qServ.findQById(qID);
		
		if(question == null) {
			return "redirect:/questions";
		}
		viewModel.addAttribute("question", question);
		
		return "showQ.jsp";
	}
	
	@PostMapping("/questions/{qID}")
	public String addAnswer(@PathVariable("qID") Long qID, Model viewModel,
			@Valid @ModelAttribute("userAnswer") Answer userAnswer, BindingResult result) {
		Question question = qServ.findQById(qID);
		if(result.hasErrors()) {
			viewModel.addAttribute("question", question);
			return "showQ.jsp";
		}
		
		qServ.addAnswer(userAnswer);
		
		return "redirect:/questions/" + qID.toString();
	}
}
