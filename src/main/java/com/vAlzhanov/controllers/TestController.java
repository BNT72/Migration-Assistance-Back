package com.vAlzhanov.controllers;

import com.vAlzhanov.dto.TestPair;
import com.vAlzhanov.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/")
    public List<TestPair> getTest(@RequestBody String testType) {
        return testService.getTest(testType);
    }
}
