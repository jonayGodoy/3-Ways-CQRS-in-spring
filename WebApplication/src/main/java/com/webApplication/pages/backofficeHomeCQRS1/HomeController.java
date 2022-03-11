package com.webApplication.pages.backofficeHomeCQRS1;

import domain.backoffice.createPizzaCQRS1.command.AddPizzaRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BackofficeHomeController1")
public class HomeController {

    @GetMapping("/backoffice1")
    public ModelAndView home() {
        return new ModelAndView(
                "backoffice/homeCQRS1/index",
                "addPizzaRequestDto",
                new AddPizzaRequestDto());
    }
}