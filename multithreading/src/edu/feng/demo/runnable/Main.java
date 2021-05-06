package edu.feng.demo.runnable;

/**
 * @program: multithreading
 * @description: TODO
 * @author: feng
 * @create: 2020-06-14 21:11
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start(); // 启动新线程
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}
