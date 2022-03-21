package com.webApplication.controllers.createPizzaControllerCQRS4;


import com.webApplication.pages.backofficeHomeCQRS4.AddPizzaRequestDto;
import domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza.CreatePizzaCommand;
import domain.share.Domain.Bus.Command.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("CreatePizzaController4")
public class CreatePizzaController {

    private final CommandBus bus;

    @Autowired
    public CreatePizzaController(CommandBus bus) {
        this.bus = bus;
    }

    @PostMapping("/backoffice4")
    public ModelAndView Execute(@ModelAttribute("addPizzaRequestDto") AddPizzaRequestDto dto){
        var command = new CreatePizzaCommand(
                dto.getImg(),
                dto.getName(),
                dto.getPrice()
        );
        bus.dispatch(command);
        var modelAndView = new ModelAndView("backoffice/homeCQRS4/index");
        modelAndView.addObject("createdPizzaSuccess", true);
        return modelAndView;
    }
}

