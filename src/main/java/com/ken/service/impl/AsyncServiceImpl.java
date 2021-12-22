package com.ken.service.impl;

import com.ken.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Ken
 * @date 2021-12-22 09:29
 * @since v1.0
 */
@Service("AsyncService")
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {

        logger.info("start executeAsync");

        System.out.println("异步线程要做的事情");
        System.out.println("可以在这里执行批量插入等耗时的事情");

        logger.info("end executeAsync");

    }
}
