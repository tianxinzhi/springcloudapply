package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigserverApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConfigserverApplication.class, args);
        // 测试用数据，仅用于本文测试使用
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        jdbcTemplate.execute("delete from yml");
        jdbcTemplate.execute("INSERT INTO yml VALUES(1, 'com.didispace.message', 'test-stage-master', 'order', 'stage', 'master')");
        jdbcTemplate.execute("INSERT INTO yml VALUES(2, 'com.didispace.message', 'test-online-master', 'order', 'online', 'master')");
        jdbcTemplate.execute("INSERT INTO yml VALUES(3, 'com.didispace.message', 'test-online-develop', 'order', 'online', 'develop')");
        jdbcTemplate.execute("INSERT INTO yml VALUES(4, 'com.didispace.message', 'hello-online-master', 'product', 'online', 'master')");
        jdbcTemplate.execute("INSERT INTO yml VALUES(5, 'com.didispace.message', 'hello-online-develop', 'product', 'online', 'develop')");
    }

}
