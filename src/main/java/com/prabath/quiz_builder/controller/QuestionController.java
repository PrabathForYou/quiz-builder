package com.prabath.quiz_builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Question> getQuestionById(@PathVariable Integer id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("category/{catagory}")
    public List<Question> getQuestionsByCatogory(@PathVariable String catagory) {
        return questionService.getQuestionsByCatogory(catagory);
    }

    @PostMapping("")
    public String addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
}