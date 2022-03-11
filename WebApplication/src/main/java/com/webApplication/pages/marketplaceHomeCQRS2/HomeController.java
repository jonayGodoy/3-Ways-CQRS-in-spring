package com.webApplication.pages.marketplaceHomeCQRS2;

import com.webApplication.pages.marketplaceHomeCQRS2.queries.getPizzas.GetPizzas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("MarketplaceHomeController2")
public class HomeController {

    private final GetPizzas getPizzas;

    @Autowired
    public HomeController(GetPizzas getPizzas) {
        this.getPizzas = getPizzas;
    }

    @GetMapping("home2")
    public ModelAndView home(Model model) {
        var pizzas = getPizzas.Execute().stream()
                .map(x -> new PizzaDto(x.getImg(), x.getName(), x.getPrice()))
                .toList();
        return new ModelAndView(
                "marketplace/homeCQRS2/index",
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
