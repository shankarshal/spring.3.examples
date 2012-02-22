package com.darekzon.spring.exhandler.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler {
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