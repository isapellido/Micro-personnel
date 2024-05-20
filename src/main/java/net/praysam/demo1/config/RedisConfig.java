package net.praysam.demo1.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import java.time.Duration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisConfig {
    /*RedisConnectionFactory redisConnectionFactory;

    private RedisSerializer<String> keySerializer() {//key的序列化方法
        return new StringRedisSerializer();
    }

    private RedisSerializer<Object> valueSerializer() {//value的序列化方法
        return new GenericJackson2JsonRedisSerializer();
    }

    //注册RedisTemplate对象
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate
                = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);//设置redis数据库连接
        redisTemplate.setKeySerializer(keySerializer());//设置key序列化
        redisTemplate.setValueSerializer(valueSerializer());//设置key序列化
        redisTemplate.setHashValueSerializer(valueSerializer());//设置哈希序列化
        return redisTemplate;
    }

    @Primary
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 生成一个默认配置，通过config对象即可对缓存进行自定义配置
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();

        redisCacheConfiguration = redisCacheConfiguration
                .entryTtl(Duration.ofMinutes(30L))// 设置缓存的默认过期时间，也是使用Duration设置
                .disableCachingNullValues() // 不缓存空值
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))//需要配置序列化，否则key会乱码
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()));//需要配置序列化，否则value会乱码

        return RedisCacheManager.
                builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory)).
                cacheDefaults(redisCacheConfiguration).build();
    }*/
}
