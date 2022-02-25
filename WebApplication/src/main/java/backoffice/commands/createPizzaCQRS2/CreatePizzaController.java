package backoffice.commands.createPizzaCQRS2;

import backoffice.commands.createPizzaCQRS2.PizzaResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller("CreatePizzaController2")
public class CreatePizzaController {

    private final CreatePizzaCommand command;

    @Autowired
    public CreatePizzaController(CreatePizzaCommand command) {
        this.command = command;
    }

    @PostMapping("/backoffice2")
    public ModelAndView Execute(
            @ModelAttribute("addPizzaRequestDto") AddPizzaRequestDto dto){
        var request = CreatePizzaRequest.create(dto);
        var pizza = command.Execute(request);
        return new ModelAndView(
                "backoffice/homeCQRS2/index",
                "pizzaResponseDto",
                new PizzaResponseDto(pizza));
    }
}

