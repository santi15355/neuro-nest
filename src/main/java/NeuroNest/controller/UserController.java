package NeuroNest.controller;


import NeuroNest.module.AI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class UserController {

    private final AI ai;

    @GetMapping()
    public ModelAndView chat() {
        return new ModelAndView("chat");
    }

    @PostMapping()
    public ModelAndView chat(@RequestParam("userMessage") String userMessage) {
        ModelAndView chat = new ModelAndView();
        String answerFromAi = ai.getAnswerFromAI(userMessage);
        chat.addObject("answer", answerFromAi);

        return chat;
    }

}
