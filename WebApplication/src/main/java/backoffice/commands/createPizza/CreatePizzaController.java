package backoffice.commands.createPizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CreatePizzaController {

    private CreatePizzaCommand command;

    @Autowired
    public CreatePizzaController(CreatePizzaCommand command) {
        this.command = command;
    }

    @PostMapping("/backoffice")
    public ModelAndView Execute(
            @ModelAttribute("addPizzaRequestDto") AddPizzaRequestDto dto,
            Model model){
        var request = CreatePizzaRequest.create(dto);
        var pizza = command.Execute(request);
        model.addAttribute("addPizzaRequestDto", new AddPizzaRequestDto());
        /*
        return pizza == null
                ?  new ResponseEntity(HttpStatus.OK)
                :  new ResponseEntity(HttpStatus.BAD_REQUEST);

         */
        return new ModelAndView(
                "backoffice/home/index",
                "addPizzaRequestDto",
                new AddPizzaRequestDto());
    }
}

