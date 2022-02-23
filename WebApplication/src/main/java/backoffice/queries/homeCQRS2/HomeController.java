package backoffice.queries.homeCQRS2;

import backoffice.commands.createPizzaCQRS1.AddPizzaRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BackofficeHomeController2")
public class HomeController {

    @GetMapping("/backoffice2")
    public ModelAndView home(Model model) {
        model.addAttribute("addPizzaRequestDto", new AddPizzaRequestDto());
        return new ModelAndView(
                "backoffice/homeCQRS2/index",
                "addPizzaRequestDto",
                new AddPizzaRequestDto());
    }
}