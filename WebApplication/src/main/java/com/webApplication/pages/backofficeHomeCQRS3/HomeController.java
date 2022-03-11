package app.cqrs.pages.backofficeHomeCQRS3;

import domain.backoffice.createPizzaCQRS1.command.AddPizzaRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BackofficeHomeController3")
public class HomeController {

    @GetMapping("/backoffice3")
    public ModelAndView home() {
        return new ModelAndView(
                "backoffice/homeCQRS3/index",
                "addPizzaRequestDto",
                new AddPizzaRequestDto());
    }
}