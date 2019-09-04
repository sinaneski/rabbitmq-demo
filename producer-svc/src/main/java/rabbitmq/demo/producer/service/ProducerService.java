package rabbitmq.demo.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.demo.producer.config.RmqProperties;
import rabbitmq.demo.producer.model.User;

@Component
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    private final RmqProperties rmqProperties;

    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate, RmqProperties rmqProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rmqProperties = rmqProperties;
    }

    public void sendMessage(User message) {
        rabbitTemplate.convertAndSend(rmqProperties.getQueueName(), message);
    }
}