package com.darekzon.spring.exhandler.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/")
	public ModelAndView index() throws Exception{
	
		throw new Exception("Throwing exception");
		
	}
	
	
	
	
}
