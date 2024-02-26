package com.example.chat_reactive_spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String content;
    private String sender;
    private LocalDateTime timestamp;
}
