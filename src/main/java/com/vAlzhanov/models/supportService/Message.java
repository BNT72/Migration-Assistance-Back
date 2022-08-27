package com.vAlzhanov.models.supportService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vAlzhanov.models.auth.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String message;

    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "user_id")
    @JsonIgnore
    private User user;

    private String username;
}
