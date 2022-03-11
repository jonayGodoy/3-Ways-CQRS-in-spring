package app.cqrs.pages.backofficeStatsCQRS3;

import app.cqrs.pages.backofficeStatsCQRS3.queries.IBackofficeStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetStatsController {

    private IBackofficeStatsRepository repository;

    @Autowired
    public GetStatsController(IBackofficeStatsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/backoffice3/stats")
    public ModelAndView home() {
        var responseDto =  repository.getStats();
        return new ModelAndView(
                "backoffice/StatsCQRS3/index",
                "backofficeStats",
                responseDto);
    }

}
