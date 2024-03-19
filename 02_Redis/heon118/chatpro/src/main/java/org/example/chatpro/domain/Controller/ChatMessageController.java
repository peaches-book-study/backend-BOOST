package org.example.chatpro.domain.Controller;

import lombok.RequiredArgsConstructor;
import org.example.chatpro.domain.Repository.ChatRoomRepository;
import org.example.chatpro.domain.model.ChatMessage;
import org.example.chatpro.domain.model.PublisherService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatMessageController {
    private final PublisherService publisherService;
    private final ChatRoomRepository chatRoomRepository;

    /**
     * websocket "/pub/chat/message"로 들어오는 메시징을 처리한다.
     */
    @MessageMapping("/chat/message")
    public void message(ChatMessage chatMessage){
        if(ChatMessage.MessageType.ENTER.equals(chatMessage.getType())){
            chatRoomRepository.enterChatRoom(chatMessage.getRoomId());
            chatMessage.setMessage(chatMessage.getSender() + "님 등장!");
        }
        // Websocket에 발행된 메시지를 redis로 발행한다(publish)
        publisherService.publish(chatRoomRepository.getTopic(chatMessage.getRoomId()), chatMessage);
    }
}
