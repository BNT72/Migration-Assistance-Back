package com.vAlzhanov.service;

import com.vAlzhanov.dto.TestQuestionDto;
import com.vAlzhanov.models.test.ETestType;
import com.vAlzhanov.repository.test.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class TestService {
    private final QuestionRepository questionRepository;

    public List<TestQuestionDto> getTest(String testType) {
        Optional<ETestType> type = Optional.of(ETestType.valueOf(testType.substring(0, testType.length()-1)));
        return questionRepository
                .findAllByType(type.orElseThrow(IllegalArgumentException::new))
                .stream()
                .map(TestQuestionDto::new)
                .collect(Collectors.toList());
    }
}
