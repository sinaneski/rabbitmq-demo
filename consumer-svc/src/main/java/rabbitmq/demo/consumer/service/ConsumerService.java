package rabbitmq.demo.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.demo.consumer.config.RmqProperties;
import rabbitmq.demo.consumer.model.User;

import java.util.concurrent.CountDownLatch;

@Component
public class ConsumerService {

    private CountDownLatch latch = new CountDownLatch(1);

    private final RmqProperties rmqProperties;

    @Autowired
    public ConsumerService(RmqProperties rmqProperties) {
        this.rmqProperties = rmqProperties;
    }

    @RabbitListener(queues = "#{rmqProperties.getQueueName()}")
    public void receiveMessage(User message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
