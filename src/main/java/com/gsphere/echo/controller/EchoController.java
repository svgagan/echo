package com.gsphere.echo.controller;

import com.gsphere.echo.model.ChatRequest;
import com.gsphere.echo.model.ChatResponse;
import com.gsphere.echo.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/echo")
public class EchoController {
    private final ChatService chatService;

    public EchoController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String reply = chatService.getReply(request.getPrompt());
        return new ChatResponse(reply);
    }
}
