package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.aspect;

import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.annatation.Lockable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Aspect
public class LockAspect {
    private final Map<String, Lock> locks = new ConcurrentHashMap<>();

    @Pointcut("@annotation(lockable)")
    public void lockable(Lockable lockable) {
    }

    @Around("lockPointcut(lockable)")
    public Object lockAdir(ProceedingJoinPoint joinPoint, Lockable lockable) throws Throwable {
        var lock = locks.computeIfAbsent(lockable.resourse(), k -> new ReentrantLock());
        try {
            lock.lock();
            return joinPoint.proceed();

        } finally {
            lock.unlock();
        }
    }
}
