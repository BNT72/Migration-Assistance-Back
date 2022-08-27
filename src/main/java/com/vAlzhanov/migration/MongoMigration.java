package com.vAlzhanov.migration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vAlzhanov.models.map.MarkerEntity;
import com.vAlzhanov.models.test.TestQuestionEntity;
import com.vAlzhanov.repository.map.MarkerRepo;
import com.vAlzhanov.repository.test.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class MongoMigration implements CommandLineRunner {
    private final QuestionRepository questionRepository;
    private final MarkerRepo markerRepo;

    public MongoMigration(QuestionRepository questionRepository, MarkerRepo markerRepo) {
        this.questionRepository = questionRepository;
        this.markerRepo = markerRepo;
    }


    @Override
    public void run(String... args) {
        ObjectMapper objectMapper = new ObjectMapper();
        testMigration(objectMapper);
        mapMigration(objectMapper);
    }

    private void testMigration(ObjectMapper objectMapper){
        List<TestQuestionEntity> testQuestionEntities;
        try {
            testQuestionEntities = objectMapper.readValue(new File("MigrationTest.json"), new TypeReference<>() {
            });
            testQuestionEntities.stream()
                    .filter(testQuestionEntity -> questionRepository.findByQuestion(testQuestionEntity.getQuestion()).isEmpty())
                    .forEach(questionRepository::insert);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void mapMigration(ObjectMapper objectMapper){
        List<MarkerEntity> testQuestionEntities;
        try {
            testQuestionEntities = objectMapper.readValue(new File("MigrationMap.json"), new TypeReference<>() {
            });
            testQuestionEntities.stream()
                    .filter(testQuestionEntity -> markerRepo.findByAddressAndName(testQuestionEntity.getName(),testQuestionEntity.getAddress()).isEmpty())
                    .forEach(markerRepo::insert);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
