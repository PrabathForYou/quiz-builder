package com.prabath.quiz_builder.service;

import org.springframework.stereotype.Service;
import com.prabath.quiz_builder.dao.QuestionDao;
import com.prabath.quiz_builder.dao.QuizDao;
import com.prabath.quiz_builder.model.Quiz;
import com.prabath.quiz_builder.model.Question;
import com.prabath.quiz_builder.model.QuestionWrapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Service
public class QuizService {
    
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title) {
        try {
            List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numberOfQuestions);

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizDao.save(quiz);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("error: " + e.getMessage());
        }

        return ResponseEntity.ok("Quiz created successfully");
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        try {
            Quiz quiz = quizDao.findById(id).orElse(null);
            if (quiz == null) {
                return ResponseEntity.status(404).body(null);
            }

            List<QuestionWrapper> questionWrappers = quiz.getQuestions().stream().map(q -> new QuestionWrapper(
                q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(),
                q.getDifficultyLevel(), q.getCategory()
            )).toList();

            return ResponseEntity.ok(questionWrappers);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
