package com.vAlzhanov.models.test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "question_types",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<TestType> type = new HashSet<>();

    @NotBlank
    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<TestAnswer> answers;

}
