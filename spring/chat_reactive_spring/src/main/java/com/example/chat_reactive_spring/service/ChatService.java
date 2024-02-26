package com.example.chat_reactive_spring.service;

import com.example.chat_reactive_spring.entity.Message;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class ChatService {


    private final Sinks.Many<Message> sink;

    public ChatService() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }


    public Mono<Void> postMessage(Message message) {
        sink.tryEmitNext(message);
        return Mono.empty();
    }


    public Flux<Message> getMessagesStream() {
        return sink.asFlux();
    }
}

