package com.epam.jmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome() {

        ModelAndView m = new ModelAndView("index");
        m.addObject("img", "/ws/img");
        m.addObject("message", "Spring 3 MVC - Hello World");
        return m;

    }
}
