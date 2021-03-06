package com.kaesar.thread;

public class ThreadExample {
  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName() + " running");

    for (int i = 0; i < 10; i++) {
      new Thread("" + i) {
        @Override
        public void run() {
          System.out.println("Thread: " + getName() + "running");
        }
      }.start();
    }
  }

}
