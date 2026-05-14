package com.prabath.quiz_builder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.prabath.quiz_builder.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String cateogory);

    @Query(value = """
        SELECT * 
        FROM question 
        WHERE category = :category 
        ORDER BY RANDOM() 
        LIMIT :limit
        """, nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(
            @Param("category") String category,
            @Param("limit") int limit
    );
}
