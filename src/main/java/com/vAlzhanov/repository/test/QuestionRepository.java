package com.vAlzhanov.repository.test;

import com.vAlzhanov.models.test.ETestType;
import com.vAlzhanov.models.test.TestQuestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends MongoRepository<TestQuestionEntity, String> {


    Optional<TestQuestionEntity> findByQuestion(String question);

    List<TestQuestionEntity> findAllByType(ETestType type);
}
