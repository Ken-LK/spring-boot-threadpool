package com.ken.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * @author Ken
 * @date 2021-12-22 09:26
 * @since v1.0
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    @Autowired
    private TaskExecutorBuilder taskExecutorBuilder;
    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor(){

        logger.info("start asyncServiceExecutor");
        return taskExecutorBuilder.build(VisiableThreadPoolTaskExecutor.class);
    }
}
