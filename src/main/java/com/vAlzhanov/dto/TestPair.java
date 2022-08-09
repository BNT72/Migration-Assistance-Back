package com.vAlzhanov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TestPair {
    private String question;
    private List<String> choices;
    private String answer;

}
