package marketplace.queries.home;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;


@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home(Model model) {
        var pizzas = Arrays.asList(
                new PizzaDto("bbq.png","bbq", 3.99f),
                new PizzaDto("4Cheeses.png","4Cheeses", 4.99f),
                new PizzaDto("carbonara.png","carbonara", 2.99f),
                new PizzaDto("Cesar.png","Cesar", 5.99f),
                new PizzaDto("hawaiana.PNG","hawaiana", -3.99f),
                new PizzaDto("nachos.png","nachos", -30.99f)
        );
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
