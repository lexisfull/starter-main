package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.init;

import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.exeption.ConcurrencyStartupException;
import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.logging.DeferredLogFactory;
import org.springframework.core.env.ConfigurableEnvironment;

public class ConcurrencyEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final Log aLong;
    public ConcurrencyEnvironmentPostProcessor(DeferredLogFactory logFactory) {
        this.aLong=logFactory.getLog(ConcurrencyEnvironmentPostProcessor.class);
    }
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        aLong.info("Вызов ConcurrencyEnvironmentPostProcessor ");
         String envName = environment.getProperty("concurrency.enabled");
         boolean isBoolValue = Boolean.TRUE.toString().equals(envName)
                 ||Boolean.FALSE.toString().equals(envName);
         if (isBoolValue) {
             try {
                 new ConcurrencyStartupException("Ошибка при проверке свойства");
             }
             catch (ConcurrencyStartupException e) {
             }
         }
    }
}
