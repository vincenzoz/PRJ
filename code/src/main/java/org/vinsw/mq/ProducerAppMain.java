package org.vinsw.mq;

public class ProducerAppMain {

    public static void main(String[] args) {
        thread(new Producer(), false);

    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }
}
