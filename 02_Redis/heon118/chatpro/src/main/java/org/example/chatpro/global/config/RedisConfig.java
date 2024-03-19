package org.example.chatpro.global.config;

import lombok.RequiredArgsConstructor;
import org.example.chatpro.domain.model.SubscriberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {
    // 단일 Topic 사용을 위한 Bean 설정
    @Bean
    public ChannelTopic channelTopic(){
        return new ChannelTopic("chatroom");
    }
    // redis pub/sub 메시지 처리 listener 설정
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory,
                                                                       MessageListenerAdapter listenerAdapter,
                                                                       ChannelTopic channelTopic){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 해당 channel에 message 들어왔을 때 적용할 리스너를 어댑터를 통해 등록
        container.addMessageListener(listenerAdapter, channelTopic);
        return container;
    }

    // 실제 message 처리하는 subscriber 설정 추가
    @Bean
    public MessageListenerAdapter listenerAdapter(SubscriberService subscriber){
        return new MessageListenerAdapter(subscriber, "sendMessage");
    }

    // redisTemplate 설정
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(String.class));
        return redisTemplate;
    }
}
