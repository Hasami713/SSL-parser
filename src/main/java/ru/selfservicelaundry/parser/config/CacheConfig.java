package ru.selfservicelaundry.parser.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        var cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(buildCaffeine());
        return cacheManager;
    }

    private Caffeine<Object, Object> buildCaffeine() {
        return Caffeine.newBuilder()
                .expireAfterWrite(30, TimeUnit.MINUTES);
    }
}