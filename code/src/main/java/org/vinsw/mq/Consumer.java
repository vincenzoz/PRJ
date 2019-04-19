package org.vinsw.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.vinsw.mq.conf.Configuration;

import javax.jms.*;

import static org.vinsw.mq.conf.Constants.QUEUE_NAME;

public class Consumer implements Runnable, ExceptionListener {

    private final static String PROTOCOL = "ssl://";

    public void run() {
        try {
            Configuration.initEnv();

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin","admin",Configuration.getBrokerUrl(PROTOCOL));
            Connection connection = connectionFactory.createConnection();
            connection.start();
            connection.setExceptionListener(this);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue(QUEUE_NAME);
            MessageConsumer consumer = session.createConsumer(destination);

            Message message = consumer.receive(1000);

            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                System.out.println("Received: " + text);
            } else {
                System.out.println("Received: " + message);
            }

            consumer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }

    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occured.  Shutting down client.");
    }
}
