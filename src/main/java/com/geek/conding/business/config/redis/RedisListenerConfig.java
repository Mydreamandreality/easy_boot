package com.geek.conding.business.config.redis;

import com.geek.conding.business.constants.RedisChannelConstants;
import com.geek.conding.server.listener.ProcessMessageChannel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/3 23:42
 * @Version v1.0
 * @Description redis pub/sub 模式配置
 */
@Configuration
public class RedisListenerConfig {

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        //监听mock_channel频道---此处可以自由扩展
        listenerContainer.addMessageListener(listenerAdapter, new PatternTopic(RedisChannelConstants.mock_channel));
        return listenerContainer;
    }

    /**
     * 消息委托对象
     *
     * @param messageChannel 委托对象
     * @return
     */
    @Bean
    public MessageListenerAdapter listenerAdapter(ProcessMessageChannel messageChannel) {
        return new MessageListenerAdapter(messageChannel, "monitorBroadcast");
    }
}
