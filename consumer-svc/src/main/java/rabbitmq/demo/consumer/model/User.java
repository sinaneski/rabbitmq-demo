package rabbitmq.demo.consumer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude
@Data
public class User {

    private String id;
    private String name;
    private String surname;
}
