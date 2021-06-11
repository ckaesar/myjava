package com.kaesar.thread.ShiZhanJavaGaoBingFaSheJi2.chp2;

/**
 * suspend() 和 resume() 方法示例
 * 这两个方法已废弃
 *
 * @Author: chengk
 * @Date: 2021/6/8 6:47 上午
 */
public class BadSuspend {
    public static Object u = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");

    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }
}