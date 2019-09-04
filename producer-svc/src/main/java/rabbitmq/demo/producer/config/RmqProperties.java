package rabbitmq.demo.producer.config;

import lombok.Data;

@Data
public class RmqProperties {
    private String queueName;
    private String exchangeName;
    private String routingKey;
}
