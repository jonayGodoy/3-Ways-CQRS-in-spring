package app.cqrs.controllers.createPizzaControllerCQRS3;

import domain.backoffice.createPizzaCQRS3.command.AddPizzaRequestDto;
import domain.backoffice.createPizzaCQRS3.command.CreatePizzaRequestEvent;
import domain.backoffice.createPizzaCQRS3.command.Pizza;
import domain.backoffice.createPizzaCQRS3.infrastructure.eventBus.CommandEventBus;
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

