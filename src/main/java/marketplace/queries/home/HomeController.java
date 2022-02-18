package marketplace.queries.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("MarketplaceHomeController")
public class HomeController {

    private GetPizzas getPizzas;

    @Autowired
    public HomeController(GetPizzas getPizzas) {
        this.getPizzas = getPizzas;
    }

    @GetMapping("/")
    public ModelAndView home(Model model) {
        var pizzas = getPizzas.Execute().stream()
                .map(x -> new PizzaDto(x.getImg(), x.getName(), x.getPrice()))
                .toList();
        return new ModelAndView(
                "marketplace/home/index",
                "pizzas",
                pizzas);
    }

    public class PizzaDto {
        public String img;
        public String name;
        public String price;

        public PizzaDto(String img, String name, float price) {
            this.img = img;
            this.name = name;
            this.price = price+"€";
        }
    }

}
