package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.filter;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Optional;

public class ConditionalOnCyclicBarrier implements Condition {


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return canUseBarrirar(context.getEnvironment());
    }

    private Boolean canUseBarrirar(Environment env) {
        var enabled = Optional.ofNullable(env.getProperty("concurrency.enabled"));
        var cyclicBarrier = Optional.ofNullable(env.getProperty("concurrency.cyclic.barrier.enabled"));
        boolean hasProps = enabled.isPresent() && cyclicBarrier.isPresent();
        return hasProps && Boolean.parseBoolean(cyclicBarrier.get());
    }
}
