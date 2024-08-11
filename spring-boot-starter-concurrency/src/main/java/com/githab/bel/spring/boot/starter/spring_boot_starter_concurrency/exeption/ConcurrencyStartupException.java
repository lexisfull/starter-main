package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.exeption;

public class ConcurrencyStartupException extends RuntimeException{
    public ConcurrencyStartupException(String message) {
        super(message);
    }
    public ConcurrencyStartupException(){
    }
}
