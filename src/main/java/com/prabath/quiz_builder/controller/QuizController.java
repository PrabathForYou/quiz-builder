package com.prabath.quiz_builder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prabath.quiz_builder.service.QuizService;
import com.prabath.quiz_builder.model.QuestionWrapper;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuizQuestions(id);
    }


    @PostMapping("create")
    public ResponseEntity<String> createQuiz
    (
          @RequestParam String category,
          @RequestParam int numberOfQuestions,
          @RequestParam String title
    ) 
    {
        return quizService.createQuiz(category, numberOfQuestions, title);
    }

    // public calculate
}
