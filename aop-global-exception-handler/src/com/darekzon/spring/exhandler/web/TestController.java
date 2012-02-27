package com.darekzon.spring.exhandler.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * Simple test class
 * @author Darek Zon
 *
 */
@Controller
public class TestController {

	/**
	 * This method will always throw exception. Exception should be catched by ExceptionHandler
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/")
	public ModelAndView index() throws Exception{
	
		throw new Exception("Throwing some exception");
		
	}
	
	
	
	
}
