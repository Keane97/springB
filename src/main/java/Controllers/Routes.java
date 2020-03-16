/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.text.DecimalFormat;
import java.util.Date;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Keane
 */
@RestController
@RequestMapping("/Beers")
//@SessionAttributes("Beers")
public class Routes {

    @Autowired
    BeerService beerService;

    @RequestMapping("/Search")
    public ModelAndView SearchPage(@Valid @ModelAttribute("Beers") Beers beer, BindingResult result, ModelMap model) {
        return new ModelAndView("/Search");
    }

    @GetMapping("/priceUpdate/{id}")
    public ModelAndView updatePrice(@PathVariable("id") int id, ModelAndView model) {
        model.addObject("Beers", beerService.getBeerById(id));
        model.setViewName("/priceUpdate");
        return model;
    }

    @RequestMapping("/SearchBeer")
    public ModelAndView SearchBeer(@RequestParam("name") String name, ModelAndView model) {
        
        model.addObject("Beers", beerService.SearchBeers(name));
        model.setViewName("/DrillDown");
        return model;
    }

    @PostMapping("/UpdateBeerPrice")
    public ModelAndView editBeer(@QueryParam("priceIncrease") double increase, @QueryParam("id") int id) {
        
        Beers beer = beerService.getBeerById(id);
        
        double UpdatedPrice = 0.0;
        
        if (increase>0) {
            double PriceIncrease = ((beer.getBuyPrice() / 100) * increase) + beer.getBuyPrice();
            System.out.println("Price increase of :" + PriceIncrease);
        } else if(increase<0){
            double PriceIncrease = ((beer.getBuyPrice() / 100.0) * increase) + beer.getBuyPrice();
            System.out.println("Price increase of :" + PriceIncrease);
        }
        DecimalFormat format= new DecimalFormat("##.00");
        
        Boolean result=true;
        
        if (result == false) {
            return new ModelAndView("/error");
        } else {
         beerService.editBeerPrice(beer, UpdatedPrice);
        }
        return new ModelAndView("redirect:/Beers/Search");
    }
}
