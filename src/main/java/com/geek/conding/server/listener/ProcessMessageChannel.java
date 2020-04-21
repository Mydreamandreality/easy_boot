package com.geek.conding.server.listener;

import com.geek.conding.business.constants.RedisChannelConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description 处理监听消息
 */
@Component
public class ProcessMessageChannel {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessMessageChannel.class);

    public void monitorBroadcast(String message) {
        try {
            LOGGER.info("监听到频道:{},消息:{}", RedisChannelConstants.mock_channel, message);
        } catch (Exception e) {
            LOGGER.error("sub 消息监听失败:{}", e.getMessage());
        }
    }
}
