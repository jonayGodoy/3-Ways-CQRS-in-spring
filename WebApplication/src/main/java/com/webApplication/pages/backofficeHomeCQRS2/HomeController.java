package com.webApplication.pages.backofficeHomeCQRS2;

import domain.backoffice.createPizzaCQRS3.command.AddPizzaRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BackofficeHomeController2")
public class HomeController {

    @GetMapping("/backoffice2")
    public ModelAndView home() {
        return new ModelAndView(
                "backoffice/homeCQRS2/index",
                "addPizzaRequestDto",
                new AddPizzaRequestDto());
    }
}