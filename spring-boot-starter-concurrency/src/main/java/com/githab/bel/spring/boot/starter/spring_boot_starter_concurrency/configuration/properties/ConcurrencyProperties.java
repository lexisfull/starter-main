package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "concurrency")

public class ConcurrencyProperties {
    private Boolean enabled;
    private Boolean lockEnabled;
    private Boolean cycleEnabled;
    private Boolean semaphoreEnabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLockEnabled() {
        return lockEnabled;
    }

    public void setLockEnabled(Boolean lockEnabled) {
        this.lockEnabled = lockEnabled;
    }

    public Boolean getCycleEnabled() {
        return cycleEnabled;
    }

    public void setCycleEnabled(Boolean cycleEnabled) {
        this.cycleEnabled = cycleEnabled;
    }

    public Boolean getSemaphoreEnabled() {
        return semaphoreEnabled;
    }

    public void setSemaphoreEnabled(Boolean semaphoreEnabled) {
        this.semaphoreEnabled = semaphoreEnabled;
    }
}
