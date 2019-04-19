package org.vinsw.mq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.vinsw.mq.conf.Configuration;

import javax.jms.*;

import static org.vinsw.mq.conf.Constants.QUEUE_NAME;

public class Producer implements Runnable {

    private final static String PROTOCOL = "ssl://";

    public void run() {
        try {
            Configuration.initEnv();

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", Configuration.getBrokerUrl(PROTOCOL));
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue(QUEUE_NAME);

            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            String text = "Text message  " + Thread.currentThread().getName() + " : " + this.hashCode();
            TextMessage message = session.createTextMessage(text);

            System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);
            session.commit();
            // Clean up
            producer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
