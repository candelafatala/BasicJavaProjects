package com.candela.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateController {
	
	@GetMapping("/")
	public String home() {
		return "dateindex.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model model) {
		LocalDateTime hoy = LocalDateTime.now();
		int hora = hoy.getHour();
		int min = hoy.getMinute();
		String tiempo = "AM";
		if(hora > 12) {
			hora -= 12;
			tiempo = "PM";
		}
		model.addAttribute("hora", hora);
		model.addAttribute("minuto", min);
		model.addAttribute("tiempo", tiempo);
		return "timetemplate.jsp";
	}
	
	@GetMapping("/date")
	public String fecha(Model model) {
		SimpleDateFormat fecha = new SimpleDateFormat("EEEE, d MMMM, yyyy");
		Date date = new Date();
		model.addAttribute("fecha", fecha.format(date));
		return "datetemplate.jsp";
	}
}
