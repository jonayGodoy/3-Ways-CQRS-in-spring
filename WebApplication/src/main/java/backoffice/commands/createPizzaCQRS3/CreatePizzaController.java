package backoffice.commands.createPizzaCQRS3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller("CreatePizzaController3")
public class CreatePizzaController {

    private final CreatePizzaCommand command;

    @Autowired
    public CreatePizzaController(CreatePizzaCommand command) {
        this.command = command;
    }

    @PostMapping("/backoffice3")
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
                "backoffice/homeCQRS3/index",
                "addPizzaRequestDto",
                new AddPizzaRequestDto());
    }
}

