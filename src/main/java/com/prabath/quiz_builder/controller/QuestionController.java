package com.prabath.quiz_builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.prabath.quiz_builder.model.Question;
import com.prabath.quiz_builder.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}