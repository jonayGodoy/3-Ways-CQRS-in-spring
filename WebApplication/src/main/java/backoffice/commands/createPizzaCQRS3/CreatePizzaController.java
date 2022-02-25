package backoffice.commands.createPizzaCQRS3;

import backoffice.commands.createPizzaCQRS3.PizzaResponseDto;
import backoffice.commands.createPizzaCQRS3.EventBus.CommandEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("CreatePizzaController3")
public class CreatePizzaController {

    private final CommandEventBus bus;

    @Autowired
    public CreatePizzaController(CommandEventBus command) {
        this.bus = command;
    }

    @PostMapping("/backoffice3")
    public ModelAndView Execute(
            @ModelAttribute("addPizzaRequestDto") AddPizzaRequestDto dto,
            Model model){
        var request = CreatePizzaRequestEvent.create(dto);
        Pizza pizza = bus.RaiseEvent(request);
        model.addAttribute("addPizzaRequestDto", new AddPizzaRequestDto());
        return new ModelAndView(
                "backoffice/homeCQRS3/index",
                "pizzaResponseDto",
                new PizzaResponseDto(pizza));
    }
}

