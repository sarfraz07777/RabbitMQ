package com.cgi.rabbitmq;

import com.rabbitmq.client.Connection;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Channel;

public class RabbitMQProducer {
    private final static String QUEUE_NAME = "CGI RabbitMQ";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // RabbitMQ server hostname
        try (Connection connection = factory.newConnection(); 
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            
            String message = "Hello, SARFARAZ!";
            
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}