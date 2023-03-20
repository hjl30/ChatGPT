package com.kfm.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "open-ai",ignoreInvalidFields = true)
@Component
@Data
public class ChatConfig {
    private String apiKey;
    private int connectTimeout;
    private String hostName;
    private int port;
}
