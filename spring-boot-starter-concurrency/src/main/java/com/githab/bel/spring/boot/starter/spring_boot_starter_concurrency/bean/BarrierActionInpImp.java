package com.githab.bel.spring.boot.starter.spring_boot_starter_concurrency.bean;

public class BarrierActionInpImp implements BarrierAction {
    @Override
    public void action() {
        System.out.println("Барьер сработал!");
    }
}
