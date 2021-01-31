package com.kaesar.design_patterns.zen.chp11;

public class BMWModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("宝马车跑起来是这样的...");
    }

    @Override
    protected void stop() {
        System.out.println("宝马车应该这样停车...");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马车的喇叭声音是这样子的...");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马车的引擎是这个声音的...");
    }
}