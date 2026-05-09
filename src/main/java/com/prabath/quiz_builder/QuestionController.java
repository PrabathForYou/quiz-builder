package com.prabath.quiz_builder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
public class QuestionController {
    @GetMapping("")
    public String getAllQuestions() {
        return "Working";
    }
}