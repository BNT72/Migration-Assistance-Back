package com.vAlzhanov.repository.test;

import com.vAlzhanov.models.test.TestQuestion;
import com.vAlzhanov.models.test.TestType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<TestQuestion, Long> {


    List<TestQuestion> findAllByType(TestType testQuestion);
}
