package com.vAlzhanov.controllers;

import com.vAlzhanov.dto.TestQuestionDto;
import com.vAlzhanov.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {


    private final TestService testService;


    @PostMapping("/")
    public List<TestQuestionDto> getTest(@RequestBody String testType) {
        return testService.getTest(testType);
    }
}
