package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.aspect;

import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.annatation.UseSemaphore;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

@Aspect
public class UseSemaphoreAspect {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UseSemaphoreAspect.class);
    private final Map<String, Semaphore> semaphoreMap = new ConcurrentHashMap<String, Semaphore>();
    @Pointcut("@annotation(useSemaphore)")
    public void C(UseSemaphore useSemaphore) {}
    @Around("useSemaphorePointcut(useSemaphore)")
    public Object useSemaphoreAround(ProceedingJoinPoint joinPoint, UseSemaphore useSemaphore) throws Throwable {
        Semaphore semaphore= semaphoreMap.get(joinPoint.getSignature().getName());
        try { semaphore.acquire();
            LOG.info("Симофор захвачен потоком"+ Thread.currentThread().threadId());
            return joinPoint.proceed();

        }
        finally {
            semaphore.release();
            LOG.info("Семафор отпушен потоком"+ Thread.currentThread().threadId());
        }

    }
}
