package com.vAlzhanov.repository.test;

import com.vAlzhanov.models.test.TestAnswer;
import com.vAlzhanov.models.test.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<TestAnswer, Long> {

    List<TestAnswer> findAllByQuestion(TestQuestion testQuestion);
}
