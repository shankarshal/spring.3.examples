package com.darekzon.spring.aopmessages.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

/**
 * This handler is called after each ModelAndView returning method, it catches
 * return value and search for specific name (Message.key)
 * 
 * @author Darek Zon
 * 
 */
public class MessagesHandler {

	@Autowired
	private HttpServletRequest request;

	public ModelAndView messageHandler(ModelAndView mav) {
		Message message = null;
		final List<Message> messages = new ArrayList<Message>();
		message = this.getFromSession();
		if (message != null) {
			messages.add(message);
		}

		message = (Message) mav.getModel().get(Message.key);
		if (message != null) {
			if (message.getNoJump()) {
				messages.add(message);
			} else {
				this.saveToSession(message);
			}
		}
		if (messages.size() > 0) {
			mav.addObject("systemMessages", messages);
		}
		return mav;
	}

	private void saveToSession(final Message message) {
		this.request.getSession().setAttribute(Message.key, message);
	}

	private Message getFromSession() {
		Message msg = (Message) this.request.getSession().getAttribute(
				Message.key);
		this.request.getSession().removeAttribute(Message.key);
		return msg;
	}
}
