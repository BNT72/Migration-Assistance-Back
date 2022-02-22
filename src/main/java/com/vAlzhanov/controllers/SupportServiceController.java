package com.vAlzhanov.controllers;

import com.vAlzhanov.models.auth.User;
import com.vAlzhanov.models.supportService.Message;
import com.vAlzhanov.repository.auth.UserRepository;
import com.vAlzhanov.repository.supportService.MessageRepo;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/supportService")
public class SupportServiceController {


    private final MessageRepo messageRepo;
    private final UserRepository userRepository;

    public SupportServiceController(MessageRepo messageRepo, UserRepository userRepository) {
        this.messageRepo = messageRepo;
        this.userRepository = userRepository;
    }


    @GetMapping("/{userName}")
    public List<Message> getDialog(@PathVariable String userName) {
        User user=userRepository.findByUsername(userName).orElseThrow();
        return messageRepo.findAllByUserOrderByDateTime(user);
    }

    @PostMapping("/{userName}")
    public List<Message> postMessage(@PathVariable String userName, @RequestBody Message messageInfo) {
        messageInfo.setDateTime(Timestamp.valueOf(LocalDateTime.now()));
        User currentUser = userRepository.findByUsername(userName).orElseThrow();
        messageInfo.setUser(currentUser);
        messageRepo.save(messageInfo);
        currentUser.getMessages().add(messageInfo);
        userRepository.save(currentUser);
        return messageRepo.findAllByUserOrderByDateTime(currentUser);
    }

    @GetMapping("/")
    public Set<User> getAllDialogs() {
        return userRepository.findAllByMessagesIsNotNull();
    }
}
