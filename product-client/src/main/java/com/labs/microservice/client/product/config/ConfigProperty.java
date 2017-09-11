package com.labs.microservice.client.product.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("labclient")
public class ConfigProperty {
    private Boolean cacheEnable = false;
    private String cacheServerIP = "localhost";

    public Boolean getCacheEnable() {
        return cacheEnable;
    }

    public void setCacheEnable(Boolean cacheEnable) {
        this.cacheEnable = cacheEnable;
    }

    public String getCacheServerIP() {
        return cacheServerIP;
    }

    public void setCacheServerIP(String cacheServerIP) {
        this.cacheServerIP = cacheServerIP;
    }
}
