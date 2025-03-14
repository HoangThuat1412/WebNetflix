package com.example.WebNetflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {
	
	@GetMapping("/about")
	public ModelAndView about() {
		ModelAndView modelAndView = new ModelAndView("about");
		
		return modelAndView;
	}
}
