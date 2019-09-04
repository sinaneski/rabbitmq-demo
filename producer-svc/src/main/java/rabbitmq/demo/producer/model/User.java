package rabbitmq.demo.producer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude
@Data
public class User {
    private String id;
    private String name;
    private String surname;
}
