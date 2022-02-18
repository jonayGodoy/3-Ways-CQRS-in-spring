package backoffice.queries;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("BackofficeHomeController")
public class HomeController {

    @GetMapping("/backoffice")
    public ModelAndView home(Model model) {
        return new ModelAndView(
                "backoffice/home/index",
                "pizzas",
                null);
    }
}