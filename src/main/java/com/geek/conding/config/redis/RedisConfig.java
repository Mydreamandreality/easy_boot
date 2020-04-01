package com.geek.conding.config.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description Redis配置
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    private static final StringRedisSerializer STRING_SERIALIZER = new StringRedisSerializer();
    private static final GenericJackson2JsonRedisSerializer JACKSON__SERIALIZER = new GenericJackson2JsonRedisSerializer();

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //设置缓存过期时间
        RedisCacheConfiguration redisCacheCfg = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(STRING_SERIALIZER))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(JACKSON__SERIALIZER));
        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheCfg)
                .build();
    }

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        // key序列化
        redisTemplate.setKeySerializer(STRING_SERIALIZER);
        // value序列化
        redisTemplate.setValueSerializer(JACKSON__SERIALIZER);
        // Hash key序列化
        redisTemplate.setHashKeySerializer(STRING_SERIALIZER);
        // Hash value序列化
        redisTemplate.setHashValueSerializer(JACKSON__SERIALIZER);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
