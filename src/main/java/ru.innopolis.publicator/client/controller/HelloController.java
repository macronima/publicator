package ru.innopolis.publicator.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

  /*  @RequestMapping("/")
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "hello";
    }*/

    @RequestMapping("/")
    public ModelAndView printWelcome() {
        ModelAndView model = new ModelAndView("hello");
        model.addObject("message", "Spring 3 MVC - Hello World");
        return model;
    }

    @RequestMapping(value = "/protected**"/*, method = RequestMethod.POST*/)
    public ModelAndView protectedPage() {

        ModelAndView model = new ModelAndView("protected");
        model.addObject("title", "Spring Security");
        model.addObject("message", "This is protected page - Only for Admin Users!");
        return model;

    }

    @RequestMapping(value = "/register**")
    public ModelAndView registerPage() {
        return new ModelAndView("register");
    }
}