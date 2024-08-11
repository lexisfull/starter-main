package com.githab.bel.spring.boot.starter.init;

import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.bean.ThredsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ConcurrencyApplicationContextinitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final Logger LOG =LoggerFactory.getLogger(ConcurrencyApplicationContextinitializer.class);
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        LOG.info("ConcurrencyApplicationContextinitializer");
        applicationContext.getBeanFactory().registerSingleton(ThredsInfo.class.getSimpleName(), new ThredsInfo());

    }
}
