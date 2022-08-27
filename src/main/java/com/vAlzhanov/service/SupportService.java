package com.vAlzhanov.service;

import com.vAlzhanov.models.auth.User;
import com.vAlzhanov.models.supportService.Message;
import com.vAlzhanov.repository.auth.UserRepository;
import com.vAlzhanov.repository.supportService.MessageRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class SupportService {
    private final MessageRepo messageRepo;
    private final UserRepository userRepository;

    public SupportService(MessageRepo messageRepo, UserRepository userRepository) {
        this.messageRepo = messageRepo;
        this.userRepository = userRepository;
    }


    public List<Message> getDialog(String userName) {
        User user = userRepository.findByUsername(userName).orElseThrow();
        return messageRepo.findAllByUserOrderByDateTime(user);
    }

    public List<Message> postMessage(String userName, Message messageInfo) {
        messageInfo.setDateTime(LocalDateTime.now());
        User currentUser = userRepository.findByUsername(userName).orElseThrow();
        messageInfo.setUser(currentUser);
        messageRepo.save(messageInfo);
        currentUser.getMessages().add(messageInfo);
        userRepository.save(currentUser);
        return messageRepo.findAllByUserOrderByDateTime(currentUser);
    }

    public Set<User> getAllDialogs() {
        return userRepository.findAllByMessagesIsNotNull();
    }
}
