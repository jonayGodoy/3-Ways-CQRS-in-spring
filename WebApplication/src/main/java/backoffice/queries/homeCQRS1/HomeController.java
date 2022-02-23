package backoffice.queries.homeCQRS1;

import backoffice.commands.createPizzaCQRS1.AddPizzaRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BackofficeHomeController1")
public class HomeController {

    @GetMapping("/backoffice1")
    public ModelAndView home(Model model) {
        model.addAttribute("addPizzaRequestDto", new AddPizzaRequestDto());
        return new ModelAndView(
                "backoffice/homeCQRS1/index",
                "addPizzaRequestDto",
                new AddPizzaRequestDto());
    }
}