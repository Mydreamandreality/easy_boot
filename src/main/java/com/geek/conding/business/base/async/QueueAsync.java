package com.geek.conding.business.base.async;

import com.geek.conding.business.constants.TaskConstants;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/4 0:05
 * @Version v1.0
 * @Description 异步消息队列
 */
@Component
public class QueueAsync {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 异步发送日志消息队列
     * <p>
     * Redis
     */
    @Async(TaskConstants.TASK_EXECUTOR)
    public void sendQueueSysLog(String ip, String uri, String methodName, String logTypeName, String logDesc) {
        ImmutableMap<String, String> queueMap = ImmutableMap.<String, String>builder()
                //用户信息暂时为null
                .put("user", "")
                .put("ip", ip)
                .put("uri", uri)
                .put("methodName", methodName)
                .put("logTypeName", logTypeName)
                .put("logDesc", logDesc)
                .build();
        redisTemplate.opsForList().rightPush("syslog:log", queueMap);
    }


    /**
     * 异步发送日志消息队列
     * <p>
     * 数据库RDS
     */
    @Async(TaskConstants.TASK_EXECUTOR)
    public void sendSysLog(String ip, String uri, String methodName, String logTypeName, String logDesc) {
        ImmutableMap<String, String> queueMap = ImmutableMap.<String, String>builder()
                .put("user", "")
                .put("ip", ip)
                .put("uri", uri)
                .put("methodName", methodName)
                .put("logTypeName", logTypeName)
                .put("logDesc", logDesc)
                .build();
        //这里要保存到数据库 之后完善
    }
}
