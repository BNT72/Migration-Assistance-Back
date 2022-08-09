package com.vAlzhanov.controllers;

import com.vAlzhanov.models.auth.User;
import com.vAlzhanov.models.supportService.Message;
import com.vAlzhanov.service.SupportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/supportService")
public class SupportServiceController {


    private final SupportService supportService;

    public SupportServiceController(SupportService supportService) {
        this.supportService = supportService;
    }


    @GetMapping("/{userName}")
    public List<Message> getDialog(@PathVariable String userName) {
        return supportService.getDialog(userName);
    }

    @PostMapping("/{userName}")
    public List<Message> postMessage(@PathVariable String userName, @RequestBody Message messageInfo) {
        return supportService.postMessage(userName, messageInfo);
    }

    @GetMapping("/")
    public Set<User> getAllDialogs() {
        return supportService.getAllDialogs();
    }
}
