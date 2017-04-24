package com.ait.devops.amq

import groovy.json.JsonSlurper

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
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
class ConnectionFactory {

    private final Connection connection;

    public ConnectionFactory(String jsonConfig)
    {
        def config = new JsonSlurper(jsonConfig).parseText(jsonConfig)
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(config.userId, config.password, config.url);
        this.connection = connectionFactory.createConnection();
    }

    public Connection getConnection()
    {
        return this.connection
    }


}
