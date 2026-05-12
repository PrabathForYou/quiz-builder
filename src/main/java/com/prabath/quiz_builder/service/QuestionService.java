package com.prabath.quiz_builder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prabath.quiz_builder.dao.QuestionDao;
import java.util.List;
import java.util.Optional;

import com.prabath.quiz_builder.model.Question;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
    
    public Optional<Question> getQuestionById(Integer id) {
        return questionDao.findById(id);
    }

    public List<Question> getQuestionsByCatogory(String catogory) {
        return questionDao.findByCategory(catogory);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);

        return "success";
    }
}
