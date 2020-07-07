package com.oceansoft.szga.smp;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value={"com.oceansoft.szga.smp.mapper","com.oceansoft.szga.smp.szsh.core.mapper"})
@EnableTransactionManagement
@EnableRedisHttpSession
@EnableCasClient
@EnableConfigurationProperties
public class Application {

    private static final Logger logger= LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("##################启动成功##################");
    }

}
