package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.filter;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Conditional(ConditionalOnCyclicBarrier.class)
public @interface ConditionalOnCyclicBarrierCondition {
}
