package NeuroNest.controller;


import NeuroNest.module.AI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final AI ai;

    @GetMapping()
    public ModelAndView user() {
        return new ModelAndView("user");
    }

    @PostMapping()
    public ModelAndView user(@RequestParam("userMessage") String userMessage) {
        ModelAndView user = new ModelAndView();
        String answerFromAi = ai.getAnswerFromAI(userMessage);
        user.addObject("answer", answerFromAi);

        return user;
    }

}
