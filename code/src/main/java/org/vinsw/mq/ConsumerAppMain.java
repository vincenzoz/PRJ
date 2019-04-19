package org.vinsw.mq;

public class ConsumerAppMain {

    public static void main(String[] args) {
        thread(new Consumer(), false);
    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread clientThread = new Thread(runnable);
        clientThread .setDaemon(daemon);
        clientThread .start();
    }
}
