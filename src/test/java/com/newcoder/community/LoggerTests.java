package com.newcoder.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest

@ContextConfiguration(classes = CommunityApplication.class) //以CommunityApplication为配置类启动
public class LoggerTests {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTests.class); //获得一个属于LoggerTests的logger

    @Test
    public void testLogger(){
        System.out.println(logger.getName());
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
