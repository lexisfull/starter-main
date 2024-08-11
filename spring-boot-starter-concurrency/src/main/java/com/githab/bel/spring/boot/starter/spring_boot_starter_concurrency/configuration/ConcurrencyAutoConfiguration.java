package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.configuration;

import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.aspect.LockAspect;
import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.aspect.UseCyclicBarrierAspect;
import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.aspect.UseSemaphoreAspect;
import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.bean.BarrierAction;
import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.bean.BarrierActionInpImp;
import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.configuration.properties.ConcurrencyProperties;
import com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.filter.ConditionalOnCyclicBarrierCondition;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@AutoConfiguration
@EnableConfigurationProperties(ConcurrencyProperties.class)
@ConditionalOnProperty(prefix = "concurrency",value = "enabled", havingValue = "true", matchIfMissing = false)
public class ConcurrencyAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public BarrierAction barrierAction(){
        return new BarrierActionInpImp();
    }
    @Bean
    @ConditionalOnExpression("${concurrency.lock-enabled:false}")
    public LockAspect lockAspect(){
        return new LockAspect();
    }
    @Bean
    @ConditionalOnCyclicBarrierCondition
    public UseCyclicBarrierAspect useCyclicBarrierAspect(BarrierAction barrierAction){
        return new UseCyclicBarrierAspect(barrierAction);
    }
    @Bean
    @ConditionalOnProperty(prefix = "concurrency",value = "semaphore-enabled", havingValue = "true", matchIfMissing = true)
    public UseSemaphoreAspect useSemaphoreAspect(){
        return new UseSemaphoreAspect();
    }
}
