package com.vAlzhanov.controllers;

import com.vAlzhanov.dto.TestPair;
import com.vAlzhanov.dto.TestTypeFabric;
import com.vAlzhanov.models.test.TestAnswer;
import com.vAlzhanov.models.test.TestQuestion;
import com.vAlzhanov.repository.test.AnswerRepository;
import com.vAlzhanov.repository.test.QuestionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public TestController(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @PostMapping("/")
    public List<TestPair> getTest(@RequestBody String testType) {
        List<TestQuestion> testQuestions=questionRepository.findAllByType(TestTypeFabric.getTestType(testType));
        List<TestPair> testPairs = new ArrayList<>();
        testQuestions.forEach(testQuestion ->
                testPairs.add(new TestPair(testQuestion.getQuestion(),
                        answerRepository.findAllByQuestion(testQuestion).stream().map(TestAnswer::getAnswer).collect(Collectors.toList()),
                        answerRepository.findAllByQuestion(testQuestion).stream().filter(TestAnswer::getCorrect).map(TestAnswer::getAnswer).collect(Collectors.toList()).get(0)
                )));

        return testPairs;
    }
}
