package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.analyzer;

import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.exeption.ConcurrencyStartupException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class ConcurencyFailereAnalyzer extends AbstractFailureAnalyzer<ConcurrencyStartupException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, ConcurrencyStartupException cause) {
        return new FailureAnalysis(cause.getMessage(),"укажите валидное значение для свойств", cause);
    }
}
