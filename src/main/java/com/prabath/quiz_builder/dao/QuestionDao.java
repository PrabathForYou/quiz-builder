package com.prabath.quiz_builder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabath.quiz_builder.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    
}
