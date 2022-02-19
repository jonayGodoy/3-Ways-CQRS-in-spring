package backoffice.queries;

import backoffice.commands.createPizza.AddPizzaRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BackofficeHomeController")
public class HomeController {

    @GetMapping("/backoffice")
    public ModelAndView home(Model model) {
        model.addAttribute("addPizzaRequestDto", new AddPizzaRequestDto());
        return new ModelAndView(
                "backoffice/home/index",
                "addPizzaRequestDto",
                new AddPizzaRequestDto());
    }

    @GetMapping("/backoffice2")
    public String home2(Model model) {
        return "backoffice/home/index";
    }
}