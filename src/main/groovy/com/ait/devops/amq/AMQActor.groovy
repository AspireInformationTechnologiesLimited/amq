package com.ait.devops.amq

import groovy.json.JsonSlurper

import javax.jms.Connection;
import javax.jms.ConnectionFactory
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Created by sande on 21/04/2017.
 */
class AMQActor {

    private final Connection connection;
    private final Session session
    private final MessageProducer producer

    public AMQActor(String jsonConfig)
    {
        def config = new JsonSlurper(jsonConfig).parseText(jsonConfig)
        ActiveMQConnectionFactory  connectionFactory = new ActiveMQConnectionFactory(config.userId, config.password, config.url);
        this.connection = connectionFactory.createConnection();
        this.connection.start();
        // Create a Session
        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (Topic or Queue)
        Destination destination = session.createQueue(config.publishTo);

        // Create a MessageProducer from the Session to the Topic or Queue
        this.producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        System.out.println("source, resourceName, messageId, threadId, createdUtc, resourceId, resourceCreatedUtc");
    }

    public void publish(String payload, String refVals){
        // Create a messages
        TextMessage message = session.createTextMessage(payload);
        this.producer.send(message);
        System.out.println(refVals);
    }

    public void tearDown(){
        // Clean up
        this.session.close();
        this.connection.close();
    }

}
