package org.example.chatpro.domain.Controller;

import lombok.RequiredArgsConstructor;
import org.example.chatpro.domain.model.ChatMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatMessageController {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic channelTopic;

    @MessageMapping("/chat/message")
    public void message(ChatMessage chatMessage){
        if(ChatMessage.MessageType.ENTER.equals(chatMessage.getType())){
            chatMessage.setMessage(chatMessage.getSender() + "님 등장!");
        }
        redisTemplate.convertAndSend(channelTopic.getTopic(), chatMessage);
    }
}
