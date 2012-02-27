package com.darekzon.spring.exhandler.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.servlet.ModelAndView;

/**
 * AspectJ class that is used for global exception handling on all methods returning ModelAndView object
 * @author Darek Zon (http://darekzon.com)
 */
public class ExceptionHandler {
	
	/**
	 * Spring instead of calling @Controller method that maps url and returns ModelAndView calls this method
	 * and pass returns, but if our @Controller methods throws exception it chatch it, renders special view file and pass to it exception message 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
    public ModelAndView exceptionHandler(ProceedingJoinPoint pjp) throws Throwable {
        ModelAndView mav = new ModelAndView();
        try {
            mav = (ModelAndView) pjp.proceed();
        } catch (Exception ae) {
            mav.addObject("exceptionMessage", ae.getMessage());
            mav.setViewName("exception");
        }
        return mav;
    }
}