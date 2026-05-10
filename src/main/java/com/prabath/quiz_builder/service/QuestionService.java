package com.prabath.quiz_builder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prabath.quiz_builder.dao.QuestionDao;
import java.util.List;
import com.prabath.quiz_builder.model.Question;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }    
}
