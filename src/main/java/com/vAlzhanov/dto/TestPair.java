package com.vAlzhanov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TestPair {
    private String question;
    private List<String> choices;
    private String answer;

}
