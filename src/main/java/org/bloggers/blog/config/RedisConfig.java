package org.bloggers.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
  @Value("${redis.host}")
  private String host;
  @Value("${redis.port}")
  private int port;

  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    JedisConnectionFactory jedisConnectionFactory = null;
    try {
      RedisStandaloneConfiguration conn = new RedisStandaloneConfiguration();
      conn.setHostName(host);
      conn.setPort(port);

      jedisConnectionFactory = new JedisConnectionFactory(conn);
    } catch (Exception e) {

    }
    return jedisConnectionFactory;
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory());
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new StringRedisSerializer());
    //Hash Operation
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashValueSerializer(new StringRedisSerializer());

    redisTemplate.setDefaultSerializer(new StringRedisSerializer());

    return redisTemplate;
  }

}
