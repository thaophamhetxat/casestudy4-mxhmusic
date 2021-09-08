package com.codegym.controller;

import com.codegym.moduls.Favourite;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/blogMusic/")
public class FavouriteController {
    @ModelAttribute("favourite")
    public Favourite setupCart() {
        return new Favourite();
    }


    @GetMapping("/favourite-add")
    public ModelAndView showFavourite (@SessionAttribute("favourite") Favourite favourite){
        ModelAndView modelAndView = new ModelAndView("/favourite");
        modelAndView.addObject("favourite",favourite);
        return modelAndView;
    }

}
