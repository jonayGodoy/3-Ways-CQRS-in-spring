package backoffice.queries.StatsCQRS3;

import backoffice.commands.createPizzaCQRS1.AddPizzaRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatsController {

    private IBackofficeStatsRepository repository;

    @Autowired
    public StatsController(IBackofficeStatsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/backoffice3/stats")
    public ModelAndView home() {
        var requestDto =  repository.getStats();
        return new ModelAndView(
                "backoffice/StatsCQRS3/index",
                "backofficeStats",
                new BackofficeStatsRequestDto(requestDto));
    }

}
