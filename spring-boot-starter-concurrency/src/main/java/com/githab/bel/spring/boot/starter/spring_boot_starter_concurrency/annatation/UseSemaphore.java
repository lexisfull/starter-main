package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.annatation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UseSemaphore {
    String target() default "defailt";
    int permits();
}
