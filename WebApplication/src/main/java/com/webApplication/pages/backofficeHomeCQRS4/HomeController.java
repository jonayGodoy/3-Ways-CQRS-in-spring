package com.webApplication.pages.backofficeHomeCQRS4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BackofficeHomeController4")
public class HomeController {

    @GetMapping("/backoffice4")
    public ModelAndView home() {
        var modelAndView = new ModelAndView("backoffice/homeCQRS4/index");
        modelAndView.addObject("addPizzaRequestDto", new AddPizzaRequestDto());
        modelAndView.addObject("createdPizzaSuccess", false);
        return modelAndView;
    }
}