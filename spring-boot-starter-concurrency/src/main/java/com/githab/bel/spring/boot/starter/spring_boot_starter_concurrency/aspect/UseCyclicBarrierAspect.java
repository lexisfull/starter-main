package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.aspect;

import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.annatation.UseCyclicBarrier;
import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.bean.BarrierAction;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Logger;

@Aspect
public class UseCyclicBarrierAspect {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UseCyclicBarrierAspect.class);
    private final Map<String, CyclicBarrier> barriers = new ConcurrentHashMap<>();
    private final BarrierAction barrierAction;

    public UseCyclicBarrierAspect(final BarrierAction barrierAction) {
        this.barrierAction = barrierAction;
    }

    @Pointcut("@annotation(useCyclicBarrier)")
    public void useCyclicBarrier(UseCyclicBarrier useCyclicBarrier) {
    }

    @Before("useCyclicBarrierPointcut(useCyclicBarrier)")

    public void beforeUseCyclicBarrier(UseCyclicBarrier useCyclicBarrier) {
        String barrierName = useCyclicBarrier.barrier();
        CyclicBarrier barrier = barriers.computeIfAbsent(barrierName, k -> new CyclicBarrier(useCyclicBarrier.parties(),
                barrierAction::action));
        try {
            LOG.info("Поток"+Thread.currentThread().threadId()+"ждет у барьера");
            barrier.await();
            LOG.info("Поток"+Thread.currentThread()+ "пересек барьер");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
