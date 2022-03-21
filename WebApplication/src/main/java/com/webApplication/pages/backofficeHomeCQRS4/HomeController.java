package com.webApplication.pages.backofficeHomeCQRS4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BackofficeHomeController4")
public class HomeController {

    @GetMapping("/backoffice4")
    public ModelAndView home() {
        return new ModelAndView(
                "backoffice/homeCQRS4/index",
                "addPizzaRequestDto",
                new AddPizzaRequestDto());
    }
}