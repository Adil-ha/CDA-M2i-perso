package com.example.chat_reactive_spring.controller;

import com.example.chat_reactive_spring.entity.Message;
import com.example.chat_reactive_spring.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/messages")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Mono<Void> postMessage(@RequestBody Message message) {
        return chatService.postMessage(message);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getMessagesStream() {
        return chatService.getMessagesStream();
    }
}
