package NeuroNest.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("home");
    }


}
