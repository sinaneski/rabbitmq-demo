package rabbitmq.demo.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import rabbitmq.demo.producer.model.User;
import rabbitmq.demo.producer.service.ProducerService;

@Controller
public class ProducerController {
    private final ProducerService messageProducerService;

    @Autowired
    public ProducerController(ProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    @RequestMapping(value="/messages", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public void sendMessage(@RequestBody User message) {
        messageProducerService.sendMessage(message);
    }
}
