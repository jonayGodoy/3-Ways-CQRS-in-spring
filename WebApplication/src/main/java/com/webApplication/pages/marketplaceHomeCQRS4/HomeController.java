package com.webApplication.pages.marketplaceHomeCQRS4;

import domain.marketplace.CQRS4.PizzasModule.Application.GetAllPizzas.GetAllPizzasQuery;
import domain.share.Domain.Bus.Query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("MarketplaceHomeController4")
public class HomeController {

    private QueryBus queryBus;

    @Autowired
    public HomeController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping(value = {"home4"})
    public ModelAndView home(Model model) {
        var response = queryBus.ask(new GetAllPizzasQuery());
        return new ModelAndView(
                "marketplace/homeCQRS4/index",
                "GetAllPizzasResponse",
                response);
    }
}
