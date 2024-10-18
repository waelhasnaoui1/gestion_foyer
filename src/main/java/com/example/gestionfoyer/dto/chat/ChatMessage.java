package com.example.gestionfoyer.dto.chat;

import com.example.gestionfoyer.controllers.chat.MessageType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

}
