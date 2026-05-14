package com.prabath.quiz_builder.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prabath.quiz_builder.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

} 
