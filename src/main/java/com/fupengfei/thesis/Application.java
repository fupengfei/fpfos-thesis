package com.fupengfei.thesis;

import com.fupengfei.thesis.configure.MyMappingRedisConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.convert.MappingRedisConverter;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.core.convert.ReferenceResolver;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.Application
 * @Author: fpfos
 * @Date: 2019-04-08 22:25
 */
@EnableAsync
@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories("com.fupengfei.thesis.repository.jpa")
@EnableRedisRepositories("com.fupengfei.thesis.repository.redis")
@EntityScan("com.fupengfei.thesis.entity")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MappingRedisConverter redisConverter(RedisMappingContext mappingContext,
                                                RedisCustomConversions customConversions,
                                                ReferenceResolver referenceResolver) {

        MyMappingRedisConverter mappingRedisConverter = new MyMappingRedisConverter(mappingContext, null, referenceResolver);

        return mappingRedisConverter;
    }

}
