package com.vAlzhanov.service;

import com.vAlzhanov.dto.TestPair;
import com.vAlzhanov.dto.TestTypeFabric;
import com.vAlzhanov.models.test.TestAnswer;
import com.vAlzhanov.models.test.TestQuestion;
import com.vAlzhanov.repository.test.AnswerRepository;
import com.vAlzhanov.repository.test.QuestionRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public TestService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public List<TestPair> getTest(String testType) {
        List<TestQuestion> testQuestions = questionRepository.findAllByType(TestTypeFabric.getTestType(testType));
        List<TestPair> testPairs = new ArrayList<>();
        testQuestions.forEach(testQuestion ->
                testPairs.add(new TestPair(testQuestion.getQuestion(),
                        answerRepository.findAllByQuestion(testQuestion).stream().map(TestAnswer::getAnswer).collect(Collectors.toList()),
                        answerRepository.findAllByQuestion(testQuestion).stream().filter(TestAnswer::getCorrect).map(TestAnswer::getAnswer).collect(Collectors.toList()).get(0)
                )));

        return testPairs;
    }
}
