package com.zheng.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Order(-1)
public class RedisProperties {
    private Integer database;
    private String host;
    private Integer port;
    private String password;
    private Integer timeout;
    /**
     * 默认30天 = 2592000s
     */
    private Integer expire = 2592000;


    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public Integer getExpire() {
        return expire;
    }

    public Integer getDatabase() {
        return database;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
