package com.darekzon.spring.aopmessages.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.darekzon.spring.aopmessages.aop.Message;
import com.darekzon.spring.aopmessages.aop.Message.MessageType;

/**
 * Test controller
 * 
 * @author Darek Zon
 */
@Controller
public class TestController {

	/**
	 * Shows index request
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("index");

		return mav;
	}

	/**
	 * Shows how notJumb trigger work. Methods adds sample message to model and
	 * view and shows view
	 * 
	 * @return
	 */
	@RequestMapping("/now")
	public ModelAndView setNowMessage() {
		final ModelAndView mav = new ModelAndView("index");
		mav.addObject(Message.key, new Message(MessageType.INFO,
				"Some message", true));
		return mav;
	}

	/**
	 * Method adds sample error message and redirects (new request) to index url
	 * 
	 * @return
	 */
	@RequestMapping("/error")
	public ModelAndView setErrorMessage() {
		final ModelAndView mav = new ModelAndView("redirect:/");
		mav.addObject(Message.key, new Message(MessageType.ERROR,
				"Some error message", false));
		return mav;
	}

	/**
	 * Method adds sample ok message and redirects (new request) to index url
	 * 
	 * @return
	 */
	@RequestMapping("/info")
	public ModelAndView setInfoMessage() {
		final ModelAndView mav = new ModelAndView("redirect:/");
		mav.addObject(Message.key, new Message(MessageType.INFO,
				"Some info message", false));
		return mav;
	}

	/**
	 * Method adds sample info message and redirects (new request) to index url
	 * 
	 * @return
	 */
	@RequestMapping("/ok")
	public ModelAndView setOKMessage() {
		final ModelAndView mav = new ModelAndView("redirect:/");
		mav.addObject(Message.key, new Message(MessageType.OK,
				"Some ok message", false));
		return mav;
	}
}
