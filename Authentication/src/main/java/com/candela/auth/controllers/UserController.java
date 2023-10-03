package com.candela.auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.candela.auth.models.LogReg;
import com.candela.auth.models.User;
import com.candela.auth.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	private final UserService uSer;
	public UserController(UserService uSer) {
		this.uSer = uSer;
	}
	
	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("login", new LogReg());
		return "registrationPage.jsp";
	}
	
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User newUser,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("login", new LogReg()); //enviamos login vacio para evitar error
			return "registrationPage.jsp";
		}
		User registeredUser = uSer.registerUser(newUser, result);
		model.addAttribute("login", new LogReg()); //enviamos login vacio para evitar error
		model.addAttribute("user", new User()); //enviamos usuario vacio para que en la pagina de registro no quede el email en el campo
		if(registeredUser != null) {
			model.addAttribute("register", "Thank you for registering!");
		}
		return "registrationPage.jsp";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LogReg loginUser,
			BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("user", new User()); //enviamos usuario vacio para evitar error
			return "registrationPage.jsp";
		}
		
		//autenticamos al usuario
		if(uSer.authenticateUser(loginUser.getEmail(), loginUser.getPassword(), result)) {
			User loggedUser = uSer.findByEmail(loginUser.getEmail());
			session.setAttribute("userID", loggedUser.getId()); //lo ingresamos a la sesion http
			return "redirect:/dashboard";
			
		} else {
			model.addAttribute("errorLog", "Please try again");
			model.addAttribute("user", new User());
			return "registrationPage.jsp";
		}
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		Long userID = (Long) session.getAttribute("userID");
		
		if(userID == null) { //si no encontramos al usuario en la sesion, redireccionamos a la ruta de registro/login
			return "redirect:/";
		} 
		
		User user = uSer.findUserById(userID);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	
	//salir de la sesion
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userID", null);
		return "redirect:/";
	}
}
