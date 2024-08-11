package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.bean;

import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.logging.Logger;

public class ThredsInfo {
    private static final Logger LOG= (Logger) LoggerFactory.getLogger(ThredsInfo.class);
    private final ThreadMXBean thredsInfo= ManagementFactory.getThreadMXBean();
    public void printThredsInfo() {
        ThreadInfo[]allThreds = thredsInfo.dumpAllThreads(true,true);
        for(ThreadInfo threadInfo:allThreds){
            LOG.info("Поток"+threadInfo.getThreadId());
            LOG.info("Имя потока"+threadInfo.getThreadName());
            LOG.info("Статус потока"+ threadInfo.getThreadState());
            LOG.info("-------------");
        }
    }
}
