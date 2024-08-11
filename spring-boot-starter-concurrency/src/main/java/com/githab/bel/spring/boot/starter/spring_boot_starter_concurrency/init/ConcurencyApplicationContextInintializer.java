package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.init;

import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.bean.ThredsInfo;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.logging.Logger;

public class ConcurencyApplicationContextInintializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static Logger LOGGER = (Logger) LoggerFactory.getLogger(ConcurencyApplicationContextInintializer.class);
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        LOGGER.info("Initializing ConcurencyApplicationContextInintializer");
        applicationContext.getBeanFactory().registerSingleton(ThredsInfo.class.getSimpleName(), new ThredsInfo());
    }
}
